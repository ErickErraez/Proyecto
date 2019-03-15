package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.Adjunto;



public interface AdjuntoDao {

	Adjunto saveAdjunto(Adjunto adjunto);
	
	void deleteAdjunto(Long idAdj);
	
	Adjunto updateUser(Adjunto adjunto);
	
	Adjunto findById(Long idAdj);
	
	List<Adjunto> findAllAdjuntos();
	
}
