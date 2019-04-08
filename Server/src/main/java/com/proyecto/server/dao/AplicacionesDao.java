package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.Aplicaciones;



public interface AplicacionesDao {

	Aplicaciones saveAplication(Aplicaciones aplicacion);
	
	void deleteAplication(Long idApp);
	
	Aplicaciones updateAplications(Aplicaciones aplicacion);
	
	Aplicaciones findById(Long idApp);
	
	List<Aplicaciones> findAllAplications();
	
}
