package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.AplicacionesDao;
import com.proyecto.server.model.Aplicaciones;


@Service("appService")
@Transactional
public class AplicacionesServiceImpl implements AplicacionesService {

	@Autowired
	private AplicacionesDao _aplicationsDao;

	@Override
	public Aplicaciones saveAplicaciones(Aplicaciones aplicaciones) {
		// TODO Auto-generated method stub
		return _aplicationsDao.saveAplication(aplicaciones);
	}

	@Override
	public void deleteAplicaciones(Long idApp) {
		// TODO Auto-generated method stub
		_aplicationsDao.deleteAplication(idApp);	
	}

	@Override
	public Aplicaciones updateAplicaciones(Aplicaciones aplicaciones) {
		// TODO Auto-generated method stub
		return _aplicationsDao.updateAplications(aplicaciones);
	}

	@Override
	public Aplicaciones findById(Long idApp) {
		// TODO Auto-generated method stub
		return _aplicationsDao.findById(idApp);
	}

	@Override
	public List<Aplicaciones> findAllAplicaciones() {
		// TODO Auto-generated method stub
		return _aplicationsDao.findAllAplications();
	}
	
	
	
}
