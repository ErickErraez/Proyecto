package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.Adjunto;

public interface AdjuntoService {
	
	Adjunto saveAdjunto(Adjunto adjunto);
	
	void deleteAdjunto(Long idAdj);
	
	Adjunto updateAdjunto(Adjunto adjunto);
	
	Adjunto findById(Long idAdj);
	
	List<Adjunto> findAllAdjunto();

}
