package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.Enterates;
import com.proyecto.server.model.Events;
import com.proyecto.server.model.UserRol;

public interface EventDao {

	Events saveEvents(Events event);

	void deleteEvents(Long idEvent);

	Events updateEvents(Events event);

	Events findById(Long idEvent);

	List<Events> findAllUsers();

	Events findByName(String title);
	
	List<Events> findAllActual();

}
