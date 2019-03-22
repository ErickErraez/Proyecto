package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.AdjuntoDao;
import com.proyecto.server.dao.BibliotecaDao;
import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Biblioteca;


@Service("bibliotecaService")
@Transactional
public class BibliotecaServiceImpl implements BibliotecaService {

	@Autowired
	private BibliotecaDao _bibliotecaDao;

	@Override
	public Biblioteca saveBiblioteca(Biblioteca biblioteca) {
		// TODO Auto-generated method stub
		return _bibliotecaDao.saveBiblioteca(biblioteca);
	}

	@Override
	public void deleteBiblioteca(Long idBib) {
		// TODO Auto-generated method stub
		_bibliotecaDao.deleteBiblioteca(idBib);
	}

	@Override
	public Biblioteca updateBiblioteca(Biblioteca biblioteca) {
		// TODO Auto-generated method stub
		return _bibliotecaDao.updateBiblioteca(biblioteca);
	}

	@Override
	public Biblioteca findById(Long idBib) {
		// TODO Auto-generated method stub
		return _bibliotecaDao.findById(idBib);
	}

	@Override
	public List<Biblioteca> findAllAdjunto() {
		// TODO Auto-generated method stub
		return _bibliotecaDao.findAllAdjuntos();
	}

	
	
	
	
}
