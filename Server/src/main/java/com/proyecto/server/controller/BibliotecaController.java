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
import com.proyecto.server.model.Biblioteca;
import com.proyecto.server.model.Catalogo;
import com.proyecto.server.service.BibliotecaService;
import com.proyecto.server.service.CatalogoService;

@Controller
@RequestMapping(value = "/biblioteca")
@CrossOrigin(origins = "*")
public class BibliotecaController {

	@Autowired
	private BibliotecaService _bibliotecaService;
	@Autowired
	private CatalogoService _catalogoService;

	// Get Apps
	@RequestMapping(value = "/getBib", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Biblioteca>> getBiblioteca() {
		List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

		bibliotecas = _bibliotecaService.findAllAdjunto();
		return new ResponseEntity<List<Biblioteca>>(bibliotecas, HttpStatus.OK);

	}

	// Save User
	@RequestMapping(value = "/saveBib", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Biblioteca bibliotecas, UriComponentsBuilder uriComponentsBuilder) {

		if (bibliotecas.getNombre().equals(null) || bibliotecas.getNombre().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_bibliotecaService.saveBiblioteca(bibliotecas);

		return new ResponseEntity<Biblioteca>(bibliotecas, HttpStatus.CREATED);

	}

	// ASSIGN Catalogos

	@RequestMapping(value = "/bib/cat", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Biblioteca> assignCatalogo(@RequestBody Biblioteca biblioteca,
			UriComponentsBuilder ucBuilder) {

		if (biblioteca.getIdBib() == null || biblioteca.getCatalogo().getIdCat() == null) {
			return new ResponseEntity("Faltan Datos", HttpStatus.CONFLICT);
		}
		Biblioteca bibliotecaSaved = _bibliotecaService.findById(biblioteca.getIdBib());
		if (bibliotecaSaved == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		Catalogo cat = _catalogoService.findById(biblioteca.getCatalogo().getIdCat());
		if (cat == null) {
			return new ResponseEntity("No se Encontro", HttpStatus.CONFLICT);
		}
		bibliotecaSaved.setCatalogo(cat);
		_bibliotecaService.updateBiblioteca(bibliotecaSaved);

		return new ResponseEntity<Biblioteca>(bibliotecaSaved, HttpStatus.OK);
	}

}
