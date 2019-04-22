package com.proyecto.server.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Enterates;
import com.proyecto.server.model.Events;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class EventDaoImpl extends AbstractSession implements EventDao {

	@Override
	public Events saveEvents(Events event) {
		// TODO Auto-generated method stub
		getSession().persist(event);
		return event;
	}

	@Override
	public void deleteEvents(Long idEvent) {
		// TODO Auto-generated method stub
		Events event = findById(idEvent);
		if (event != null) {
			
			getSession().delete(idEvent);
		}
	}

	@Override
	public Events updateEvents(Events event) {
		// TODO Auto-generated method stub
		getSession().update(event);
		return event;
	}

	@Override
	public Events findById(Long idEvent) {
		// TODO Auto-generated method stub
		return getSession().get(Events.class, idEvent);
	}
	
	@Override
	public List<Events> findAllUsers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Events").list();
	}

	@Override
	public Events findByName(String title) {
		// TODO Auto-generated method stub
		return (Events) getSession().createQuery(
				"from Events where title = :title")
				.setParameter("title", title).uniqueResult();
	}
	
	@Override
	public List<Events> findAllActual() {
		// TODO Auto-generated method stub
		Date objDate = new Date(); 
		 SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");  
		return  getSession().createQuery("from Events  where start = :start")
				.setParameter("start", objSDF.format(objDate)).list();
	}
	
	
}
