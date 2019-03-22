package com.proyecto.server.service;
import java.util.List;
import com.proyecto.server.model.Catalogo;

public interface CatalogoService {
	
	Catalogo saveCatalogo(Catalogo catalogo);
	
	void deleteCatalogo(Long idCat);
	
	Catalogo updateCatalogo(Catalogo catalogo);
	
	Catalogo findById(Long idCat);
	
	List<Catalogo> findAllAdjunto();

}
