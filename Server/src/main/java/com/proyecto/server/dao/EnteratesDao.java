package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Enterates;



public interface EnteratesDao {

	Enterates saveEnterates(Enterates enterates);
	
	void deleteEnterates(Long idEnt);
	
	Enterates updateEnterates(Enterates enterates);
	
	Enterates findById(Long idEnt);
	
	List<Enterates> findAllEnterates();
	
}
