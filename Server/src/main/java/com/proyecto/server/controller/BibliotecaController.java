package com.proyecto.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Get By Id

	@RequestMapping(value = "/getBiblioteca/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Biblioteca> getBibliotecaById(@PathVariable("id") Long id) {
		Biblioteca biblioteca = _bibliotecaService.findById(id);
		if (biblioteca == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Biblioteca>(biblioteca, HttpStatus.OK);
	}

	// Save User
	@RequestMapping(value = "/saveBib", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Biblioteca bibliotecas, UriComponentsBuilder uriComponentsBuilder) {

		if (bibliotecas.getNombre().equals(null) || bibliotecas.getNombre().isEmpty()) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}
		if (_bibliotecaService.findByName(bibliotecas.getNombre()) != null) {
			return new ResponseEntity("Ya existe", HttpStatus.CONFLICT);
		}

		_bibliotecaService.saveBiblioteca(bibliotecas);

		return new ResponseEntity<Biblioteca>(bibliotecas, HttpStatus.CREATED);

	}

	// ASSIGN Catalogos

}
