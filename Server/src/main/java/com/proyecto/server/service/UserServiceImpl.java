package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.UserDao;
import com.proyecto.server.model.Usuarios;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao _userDao;
	
	@Override
	public Usuarios saveUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		return _userDao.saveUser(usuario);
	}

	@Override
	public void deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		_userDao.deleteUser(idUser);
	}

	@Override
	public Usuarios updateUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		return _userDao.updateUser(usuario);
	}

	@Override
	public Usuarios findById(Long idUser) {
		// TODO Auto-generated method stub
		return _userDao.findById(idUser);
	}

	@Override
	public Usuarios findByName(String nombre) {
		// TODO Auto-generated method stub
		return _userDao.findByName(nombre);
	}

	@Override
	public List<Usuarios> findAllUsers() {
		// TODO Auto-generated method stub
		return _userDao.findAllUsers();
	}

	
}
