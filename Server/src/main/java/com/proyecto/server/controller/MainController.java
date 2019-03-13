package com.proyecto.server.controller;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.ldap.core.LdapOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Esta Clase es la principal de todos los controladores.
 * 
 */

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Bienvenido al Sistema";
		
		System.out.println(org.hibernate.Version.getVersionString());
		return response;
	}

}
