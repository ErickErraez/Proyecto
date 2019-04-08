package com.proyecto.server.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Events;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.service.AdjuntoService;
import com.proyecto.server.service.EventService;
import com.proyecto.server.service.UserRolService;

@Controller
@RequestMapping(value = "/event")
@CrossOrigin(origins = "*")
public class EventController {

	@Autowired
	private EventService _eventService;

	// Get ADJS
	@RequestMapping(value = "/getEvents", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Events>> getAdjuntos() {
		List<Events> events = new ArrayList<Events>();

		events = _eventService.findAllUsers();
		return new ResponseEntity<List<Events>>(events, HttpStatus.OK);

	}

	// Save Event
	@RequestMapping(value = "/saveEvent", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createApp(@RequestBody Events events, UriComponentsBuilder uriComponentsBuilder) {

		if (events.getTitle().equals(null) || events.getTitle().isEmpty() || events.getStart().equals(null)
				|| events.getEnd().equals(null)) {
			return new ResponseEntity("El Nombre es requerido", HttpStatus.CONFLICT);
		}

		_eventService.saveEvents(events);

		return new ResponseEntity<Events>(events, HttpStatus.CREATED);

	}

	// Update Event
	@RequestMapping(value = "/updateEvent/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> updateEvent(@PathVariable("id") Long id, @RequestBody Events event) {

		Events eventUpdate = _eventService.findById(id);
		if (eventUpdate == null) {
			return new ResponseEntity("No se encuenta", HttpStatus.NOT_FOUND);
		}
		
		eventUpdate.setTitle(event.getTitle());
		eventUpdate.setStart(event.getStart());
		eventUpdate.setEnd(event.getEnd());
		
		_eventService.updateEvents(eventUpdate);
		
		return new ResponseEntity<Events>(eventUpdate, HttpStatus.OK);
	}

}
