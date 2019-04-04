package com.proyecto.server.dao;

import java.util.List;
import com.proyecto.server.model.Catalogo;



public interface CatalogoDao {

	Catalogo saveCatalogo(Catalogo catalogo);
	
	void deleteCatalogo(Long idCat);
	
	Catalogo updateCatalogo(Catalogo catalogo);
	
	Catalogo findById(Long idCat);
	
	Catalogo findByName(String nombre);
	
	List<Catalogo> findAllAdjuntos();
	
}
