package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class AplicacionesDaoImpl extends AbstractSession implements AplicacionesDao {

	@Override
	public Aplicaciones saveAplication(Aplicaciones aplicacion) {
		getSession().persist(aplicacion);
		return aplicacion;
	}

	@Override
	public void deleteAplication(Long idApp) {
		Aplicaciones aplicacion = findById(idApp);
		if (aplicacion != null) {
			
			getSession().delete(aplicacion);
		}
		
	}

	@Override
	public Aplicaciones updateAplications(Aplicaciones aplicacion) {
		// TODO Auto-generated method stub
		getSession().update(aplicacion);
		return aplicacion;
	}

	@Override
	public Aplicaciones findById(Long idApp) {
		// TODO Auto-generated method stub
		return getSession().get(Aplicaciones.class, idApp);
	}

	@Override
	public List<Aplicaciones> findAllAplications() {
		return getSession().createQuery("from Aplicaciones").list();
	}

	
	
	
}
