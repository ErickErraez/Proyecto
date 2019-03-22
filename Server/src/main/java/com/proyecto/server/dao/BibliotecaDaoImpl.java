package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Biblioteca;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class BibliotecaDaoImpl extends AbstractSession implements BibliotecaDao {

	
	
	
	@Override
	public Biblioteca saveBiblioteca(Biblioteca biblioteca) {
		getSession().persist(biblioteca);
		return biblioteca;
	}

	@Override
	public void deleteBiblioteca(Long idBib) {
		Biblioteca biblioteca = findById(idBib);
		if (biblioteca != null) {
			
			getSession().delete(biblioteca);
		}
	}

	@Override
	public Biblioteca updateBiblioteca(Biblioteca biblioteca) {
		// TODO Auto-generated method stub
				getSession().update(biblioteca);
				return biblioteca;
	}

	@Override
	public List<Biblioteca> findAllAdjuntos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Biblioteca").list();
	}

	@Override
	public Biblioteca findById(Long idBib) {
		// TODO Auto-generated method stub
		return getSession().get(Biblioteca.class, idBib);
	}

	
	
	
	
}
