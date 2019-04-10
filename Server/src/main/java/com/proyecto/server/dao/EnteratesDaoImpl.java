package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Enterates;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class EnteratesDaoImpl extends AbstractSession implements EnteratesDao {

	@Override
	public Enterates saveEnterates(Enterates enterates) {
		getSession().persist(enterates);
		return enterates;
	}

	@Override
	public void deleteEnterates(Long idEnt) {
		Enterates enterates = findById(idEnt);
		if (enterates != null) {
			
			getSession().delete(enterates);
		}
		
	}

	@Override
	public Enterates updateEnterates(Enterates enterates) {
		// TODO Auto-generated method stub
		getSession().update(enterates);
		return enterates;
	}

	@Override
	public Enterates findById(Long idEnt) {
		// TODO Auto-generated method stub
		return getSession().get(Enterates.class, idEnt);
	}

	@Override
	public List<Enterates> findAllEnterates() {
		return getSession().createQuery("from Enterates order by fecha desc").list();
	}

	
	
	
}
