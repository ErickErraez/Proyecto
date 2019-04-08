package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.Biblioteca;



public interface BibliotecaDao {

	Biblioteca saveBiblioteca(Biblioteca biblioteca);
	
	void deleteBiblioteca(Long idBib);
	
	Biblioteca updateBiblioteca(Biblioteca biblioteca);
	
	Biblioteca findById(Long idBib);
	
	Biblioteca findByName(String nombre);
	
	List<Biblioteca> findAllAdjuntos();
	
}
