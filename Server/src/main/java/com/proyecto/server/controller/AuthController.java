package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.AuthModel;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*")
public class AuthController {

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
				return new ResponseEntity(HttpStatus.OK);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

		}

	}

}
