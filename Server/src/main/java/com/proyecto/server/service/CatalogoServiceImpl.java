package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.AdjuntoDao;
import com.proyecto.server.dao.BibliotecaDao;
import com.proyecto.server.dao.CatalogoDao;
import com.proyecto.server.model.Adjunto;
import com.proyecto.server.model.Biblioteca;
import com.proyecto.server.model.Catalogo;

@Service("catalogoService")
@Transactional
public class CatalogoServiceImpl implements CatalogoService {

	@Autowired
	private CatalogoDao _catalogoDao;

	@Override
	public Catalogo saveCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		return _catalogoDao.saveCatalogo(catalogo);
	}

	@Override
	public void deleteCatalogo(Long idCat) {
		// TODO Auto-generated method stub
		_catalogoDao.deleteCatalogo(idCat);
	}

	@Override
	public Catalogo updateCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		return _catalogoDao.updateCatalogo(catalogo);
	}

	@Override
	public Catalogo findById(Long idCat) {
		// TODO Auto-generated method stub
		return _catalogoDao.findById(idCat);
	}

	@Override
	public List<Catalogo> findAllAdjunto() {
		// TODO Auto-generated method stub
		return _catalogoDao.findAllAdjuntos();
	}

}
