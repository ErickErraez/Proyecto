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
import com.proyecto.server.service.AdjuntoService;

@Controller
@RequestMapping(value = "/adjunto")
@CrossOrigin(origins = "*")
public class AdjController {

	@Autowired
	private AdjuntoService _adjService;

	// Get ADJS
	@RequestMapping(value = "/getAdjs", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Adjunto>> getAdjuntos() {
		List<Adjunto> adjs = new ArrayList<Adjunto>();

		adjs = _adjService.findAllAdjunto();
		return new ResponseEntity<List<Adjunto>>(adjs, HttpStatus.OK);

	}

	// Save User
	@RequestMapping(value = "/saveAdjs", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Adjunto adjs, UriComponentsBuilder uriComponentsBuilder) {

		if (adjs.getTipoArchivo().equals(null) || adjs.getTipoArchivo().isEmpty() || adjs.getAdjuntoArchivo().equals(null) || adjs.getAdjuntoArchivo().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_adjService.saveAdjunto(adjs);

		return new ResponseEntity<Adjunto>(adjs, HttpStatus.CREATED);

	}

}
