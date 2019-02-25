package com.proyecto.server.controller;

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
	public String index(){
		String response = "Bienvenido al Sistema";
		System.out.println(org.hibernate.Version.getVersionString());
		return response;
	}
	
}
