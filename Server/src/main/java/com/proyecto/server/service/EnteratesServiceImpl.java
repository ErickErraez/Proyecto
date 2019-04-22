package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.AplicacionesDao;
import com.proyecto.server.dao.EnteratesDao;
import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Enterates;


@Service("enterateService")
@Transactional
public class EnteratesServiceImpl implements EnteratesService {

	@Autowired
	private EnteratesDao _enteratesDao;

	@Override
	public Enterates saveEnterates(Enterates enterates) {
		// TODO Auto-generated method stub
		return _enteratesDao.saveEnterates(enterates);
	}

	@Override
	public void deleteEnterates(Long idEnt) {
		// TODO Auto-generated method stub
		_enteratesDao.deleteEnterates(idEnt);	
	}

	@Override
	public Enterates updateEnterates(Enterates enterates) {
		// TODO Auto-generated method stub
		return _enteratesDao.updateEnterates(enterates);
	}

	@Override
	public Enterates findById(Long idEnt) {
		// TODO Auto-generated method stub
		return _enteratesDao.findById(idEnt);
	}

	
	
	@Override
	public Enterates findLastId() {
		// TODO Auto-generated method stub
		return _enteratesDao.findLastId();
	}

	@Override
	public List<Enterates> findAllActual() {
		// TODO Auto-generated method stub
		return _enteratesDao.findAllActual();
	}

	@Override
	public List<Enterates> findAllEnterates() {
		// TODO Auto-generated method stub
		return _enteratesDao.findAllEnterates();
	}
	
	
	
}
