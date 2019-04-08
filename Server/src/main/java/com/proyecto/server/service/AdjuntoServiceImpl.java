package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.AdjuntoDao;
import com.proyecto.server.model.Adjunto;


@Service("adjuntoService")
@Transactional
public class AdjuntoServiceImpl implements AdjuntoService {

	@Autowired
	private AdjuntoDao _adjuntoDao;

	@Override
	public Adjunto saveAdjunto(Adjunto adjunto) {
		// TODO Auto-generated method stub
		return _adjuntoDao.saveAdjunto(adjunto);
	}

	@Override
	public void deleteAdjunto(Long idAdj) {
		// TODO Auto-generated method stub
		_adjuntoDao.deleteAdjunto(idAdj);
	}

	@Override
	public Adjunto updateAdjunto(Adjunto adjunto) {
		// TODO Auto-generated method stub
		return _adjuntoDao.updateUser(adjunto);
	}

	@Override
	public Adjunto findById(Long idAdj) {
		// TODO Auto-generated method stub
		return _adjuntoDao.findById(idAdj);
	}

	@Override
	public List<Adjunto> findAllAdjunto() {
		// TODO Auto-generated method stub
		return _adjuntoDao.findAllAdjuntos();
	}
	
	
	
}
