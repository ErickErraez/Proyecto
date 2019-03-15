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
import com.proyecto.server.service.AdjuntoService;
import com.proyecto.server.service.AplicacionesService;

@Controller
@RequestMapping(value = "/aplications")
@CrossOrigin(origins = "*")
public class AppController {

	@Autowired
	private AplicacionesService _appService;
	@Autowired
	private AdjuntoService _adjService;

	// Get Apps
	@RequestMapping(value = "/getApps", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Aplicaciones>> getApps() {
		List<Aplicaciones> apps = new ArrayList<Aplicaciones>();

		apps = _appService.findAllAplicaciones();
		return new ResponseEntity<List<Aplicaciones>>(apps, HttpStatus.OK);

	}

	// Save User
	@RequestMapping(value = "/saveApp", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Aplicaciones apps, UriComponentsBuilder uriComponentsBuilder) {

		if (apps.getNombre().equals(null) || apps.getNombre().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_appService.saveAplicaciones(apps);

		return new ResponseEntity<Aplicaciones>(apps, HttpStatus.CREATED);

	}

	// ASSIGN IMAGE TO APPS

	@RequestMapping(value = "/apps/adjs", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Aplicaciones> assignAplicacionesToImage(@RequestBody Aplicaciones apps,
			UriComponentsBuilder ucBuilder) {
		System.out.println(apps);
		if (apps.getIdApp() == null || apps.getAdjunto().getIdAdj() == null) {
			return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
		}
		Aplicaciones appsSaved = _appService.findById(apps.getIdApp());
		if (appsSaved == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		Adjunto adjs = _adjService.findById(apps.getAdjunto().getIdAdj());
		if (adjs == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		appsSaved.setAdjunto(adjs);
		_appService.updateAplicaciones(appsSaved);

		return new ResponseEntity<Aplicaciones>(appsSaved, HttpStatus.OK);
	}

}
