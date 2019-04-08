package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.Aplicaciones;

public interface AplicacionesService {
	
	Aplicaciones saveAplicaciones(Aplicaciones aplicaciones);
	
	void deleteAplicaciones(Long idApp);
	
	Aplicaciones updateAplicaciones(Aplicaciones aplicaciones);
	
	Aplicaciones findById(Long idApp);
	
	List<Aplicaciones> findAllAplicaciones();
	

}
