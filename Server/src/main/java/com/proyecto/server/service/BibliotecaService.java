package com.proyecto.server.service;
import java.util.List;
import com.proyecto.server.model.Biblioteca;

public interface BibliotecaService {
	
	Biblioteca saveBiblioteca(Biblioteca biblioteca);
	
	void deleteBiblioteca(Long idBib);
	
	Biblioteca updateBiblioteca(Biblioteca biblioteca);
	
	Biblioteca findById(Long idBib);
	
	List<Biblioteca> findAllAdjunto();
	
	Biblioteca findByName(String nombre);

}
