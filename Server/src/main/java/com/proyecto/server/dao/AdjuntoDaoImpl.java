package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.Adjunto;


@Repository
@Transactional
public class AdjuntoDaoImpl extends AbstractSession implements AdjuntoDao {

	@Override
	public Adjunto saveAdjunto(Adjunto adjunto) {
		getSession().persist(adjunto);
		return adjunto;
	}

	@Override
	public void deleteAdjunto(Long idAdj) {
		Adjunto adjunto = findById(idAdj);
		if (adjunto != null) {
			
			getSession().delete(adjunto);
		}
	}

	@Override
	public Adjunto updateUser(Adjunto adjunto) {
		
		getSession().update(adjunto);
		return adjunto;
	}

	@Override
	public Adjunto findById(Long idAdj) {
		// TODO Auto-generated method stub
		return getSession().get(Adjunto.class, idAdj);
	}

	@Override
	public List<Adjunto> findAllAdjuntos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Adjunto").list();
	}

	
	
}
