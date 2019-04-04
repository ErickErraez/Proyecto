package com.proyecto.server.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.model.Usuarios;
import com.proyecto.server.service.BibliotecaService;
import com.proyecto.server.service.UserRolService;
import com.proyecto.server.service.UserService;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private UserService _userService;

	@Autowired
	private UserRolService _userRolService;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUser(@RequestBody AuthModel auth, UriComponentsBuilder uriComponentsBuilder) {

		if (auth.getUser().equals(null) || auth.getPassword().equals(null)) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		else {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.PROVIDER_URL, "ldap://10.0.20.63");

			env.put(Context.SECURITY_PRINCIPAL, auth.getUser());
			env.put(Context.SECURITY_CREDENTIALS, auth.getPassword());
			DirContext ctx;

			try {
				ctx = new InitialDirContext(env);

				if (_userService.findByName(auth.getUser()) != null) {
					AuthModel userReturn = _userService.findByName(auth.getUser());
					return new ResponseEntity(userReturn, HttpStatus.OK);
				} else {
					_userService.saveUser(auth);
					AuthModel user = _userService.findByName(auth.getUser());
					if (user.getIdUser() == null || user.getUserRol().getIdRol() == null) {
						return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
					}

					if (user == null) {
						return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
					}
					UserRol rol = _userRolService.findById(auth.getUserRol().getIdRol());
					if (rol == null) {
						return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
					}
					user.setUserRol(rol);
					user.setPassword(getMD5(user.getPassword()));
					_userService.updateUser(user);
					return new ResponseEntity<AuthModel>(user, HttpStatus.CREATED);

				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		}

	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<AuthModel>> getApps() {
		List<AuthModel> users = new ArrayList<AuthModel>();

		users = _userService.findAllUsers();
		return new ResponseEntity<List<AuthModel>>(users, HttpStatus.OK);

	}
	
	

	@RequestMapping(value = "/userChangeRol", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<AuthModel> assignAplicacionesToImage(@RequestBody AuthModel user,
			UriComponentsBuilder ucBuilder) {
		
		if (user.getIdUser() == null || user.getUserRol().getIdRol() == null) {
			return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
		}

		if (user == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		UserRol rol = _userRolService.findById(user.getUserRol().getIdRol());
		if (rol == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		user.setUserRol(rol);
		_userService.updateUser(user);
		return new ResponseEntity<AuthModel>(user, HttpStatus.CREATED);

	}
	

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getSHA(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
