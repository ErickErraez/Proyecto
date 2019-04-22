package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Events;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.model.Usuarios;

public interface EventService {
	
	Events saveEvents(Events event);
	
	void deleteEvents(Long idEvents);
	
	Events updateEvents(Events event);
	
	Events findById(Long idEvent);
	
	List<Events> findAllUsers();
	
	Events findByName(String title);

	List<Events> findAllActual();
	
}
