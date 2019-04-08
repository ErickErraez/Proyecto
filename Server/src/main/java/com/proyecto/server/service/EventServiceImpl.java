package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.EventDao;
import com.proyecto.server.dao.UserDao;
import com.proyecto.server.dao.UserRolDao;
import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Events;
import com.proyecto.server.model.UserRol;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao _eventDao;

	@Override
	public Events saveEvents(Events event) {
		// TODO Auto-generated method stub
		return _eventDao.saveEvents(event);
	}

	@Override
	public void deleteEvents(Long idEvent) {
		// TODO Auto-generated method stub
		_eventDao.deleteEvents(idEvent);
	}

	@Override
	public Events updateEvents(Events event) {
		// TODO Auto-generated method stub
		return _eventDao.updateEvents(event);
	}

	@Override
	public Events findById(Long idEvent) {
		// TODO Auto-generated method stub
		return _eventDao.findById(idEvent);
	}

	@Override
	public Events findByName(String title) {
		// TODO Auto-generated method stub
		return _eventDao.findByName(title);
	}

	@Override
	public List<Events> findAllUsers() {
		// TODO Auto-generated method stub
		return _eventDao.findAllUsers();
	}

}
