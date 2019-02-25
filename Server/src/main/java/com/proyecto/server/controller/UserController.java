package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.Usuarios;
import com.proyecto.server.service.UserService;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService _userService;
	
	
	//Get Users
	@RequestMapping(value = "/getUser", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Usuarios>> getUsers(@RequestParam(value = "name", required = false) String name) {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();

		if (name == null) {
			usuarios = _userService.findAllUsers();
			if (usuarios.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}

			return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
		} else {
			Usuarios usuario = _userService.findByName(name);
			if (usuario == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			usuarios.add(usuario);
			return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
		}

	}
	
	//Get User By Id
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<Usuarios> getUserById(@PathVariable("id") Long id) {
		Usuarios usuario = _userService.findById(id);
		if (usuario == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
	}
	
	
	//Save User
	@RequestMapping(value = "/postUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUser(@RequestBody Usuarios usuario, UriComponentsBuilder uriComponentsBuilder) {

		if (usuario.getNombre().equals(null) || usuario.getNombre().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}
		

		_userService.saveUser(usuario);

		return new ResponseEntity<Usuarios>(usuario, HttpStatus.CREATED);

	}

	//DELETE
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
		Usuarios usuario = _userService.findById(id);
		if (usuario == null) {

			return new ResponseEntity(("Unable to delete. teacher with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		_userService.deleteUser(id);
		return new ResponseEntity<Usuarios>(HttpStatus.OK);
	}
}

