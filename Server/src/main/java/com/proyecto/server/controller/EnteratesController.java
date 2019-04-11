package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Enterates;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.service.AdjuntoService;
import com.proyecto.server.service.AplicacionesService;
import com.proyecto.server.service.EnteratesService;

@Controller
@RequestMapping(value = "/enterates")
@CrossOrigin(origins = "*")
public class EnteratesController {

	@Autowired
	private EnteratesService _enteratesService;
	@Autowired
	private AdjuntoService _adjService;

	// Get Apps
	@RequestMapping(value = "/getEnterates", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Enterates>> getEnterates() {
		List<Enterates> enterates = new ArrayList<Enterates>();

		enterates = _enteratesService.findAllEnterates();
		return new ResponseEntity<List<Enterates>>(enterates, HttpStatus.OK);

	}

	// Save User
	@RequestMapping(value = "/saveEnterates", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Enterates enterates, UriComponentsBuilder uriComponentsBuilder) {

		if (enterates.getTitulo().equals(null) ||enterates.getTitulo().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_enteratesService.saveEnterates(enterates);

		return new ResponseEntity<Enterates>(enterates, HttpStatus.CREATED);

	}

	// ASSIGN IMAGE TO APPS

	@RequestMapping(value = "/ent/adjs", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Enterates> assignEnteratesToImage(@RequestBody Enterates ents,
			UriComponentsBuilder ucBuilder) {
		
		if ( ents.getIdEnt() == null ||  ents.getAdjunto().getIdAdj() == null) {
			return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
		}
		Enterates entSaved = _enteratesService.findById(ents.getIdEnt());
		if (entSaved == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		Adjunto adjs = _adjService.findById(ents.getAdjunto().getIdAdj());
		if (adjs == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		entSaved.setAdjunto(adjs);
		_enteratesService.updateEnterates(entSaved);

		return new ResponseEntity<Enterates>(entSaved, HttpStatus.OK);
	}
	
	

}
