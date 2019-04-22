package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Enterates;

public interface EnteratesService {
	
	Enterates saveEnterates(Enterates enterates);
	
	void deleteEnterates(Long idEnt);
	
	Enterates updateEnterates(Enterates enterates);
	
	Enterates findById(Long idEnt);
	
	Enterates findLastId();
	
	List<Enterates> findAllActual();
	
	List<Enterates> findAllEnterates();
	

}
