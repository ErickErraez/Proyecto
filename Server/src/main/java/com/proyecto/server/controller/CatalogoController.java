package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Catalogo;
import com.proyecto.server.service.AdjuntoService;
import com.proyecto.server.service.CatalogoService;

@Controller
@RequestMapping(value = "/catalogo")
@CrossOrigin(origins = "*")
public class CatalogoController {

	@Autowired
	private CatalogoService _catalogoService;
	@Autowired
	private AdjuntoService _adjService;

	// Get Apps
	@RequestMapping(value = "/getCat", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Catalogo>> getCatalogo() {
		List<Catalogo> catalogo = new ArrayList<Catalogo>();

		catalogo = _catalogoService.findAllAdjunto();
		return new ResponseEntity<List<Catalogo>>(catalogo, HttpStatus.OK);

	}

	// Save User
	@RequestMapping(value = "/saveCat", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCatalogo(@RequestBody Catalogo cats, UriComponentsBuilder uriComponentsBuilder) {

		if (cats.getNombre().equals(null) || cats.getNombre().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_catalogoService.saveCatalogo(cats);

		return new ResponseEntity<Catalogo>(cats, HttpStatus.CREATED);

	}

	// ASSIGN IMAGE TO APPS

	@RequestMapping(value = "/cats/adjs", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Catalogo> assignAplicacionesToImage(@RequestBody Catalogo cats,
			UriComponentsBuilder ucBuilder) {
	
		if (cats.getIdCat() == null || cats.getAdjunto().getIdAdj() == null) {
			return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
		}
		Catalogo catsSaved = _catalogoService.findById(cats.getIdCat());
		if (catsSaved == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		Adjunto adjs = _adjService.findById(cats.getAdjunto().getIdAdj());
		if (adjs == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		catsSaved.setAdjunto(adjs);
		_catalogoService.updateCatalogo(catsSaved);

		return new ResponseEntity<Catalogo>(catsSaved, HttpStatus.OK);
	}

}
