package com.proyecto.server.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.server.dao.UserDao;
import com.proyecto.server.dao.UserRolDao;
import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.UserRol;

@Service("userRolService")
@Transactional
public class UserRolServiceImpl implements UserRolService {

	@Autowired
	private UserRolDao _userRolDao;

	@Override
	public UserRol saveUser(UserRol rol) {
		// TODO Auto-generated method stub
		return _userRolDao.saveUser(rol);
	}

	@Override
	public void deleteUser(Long idRol) {
		// TODO Auto-generated method stub
		_userRolDao.deleteUser(idRol);
	}

	@Override
	public UserRol updateUser(UserRol rol) {
		// TODO Auto-generated method stub
		return _userRolDao.updateUser(rol);
	}

	@Override
	public UserRol findById(Long idRol) {
		// TODO Auto-generated method stub
		return _userRolDao.findById(idRol);
	}

	@Override
	public UserRol findByName(String descripcion) {
		// TODO Auto-generated method stub
		return _userRolDao.findByName(descripcion);
	}

	@Override
	public List<UserRol> findAllUsers() {
		// TODO Auto-generated method stub
		return _userRolDao.findAllUsers();
	}

}
