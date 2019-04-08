package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class UserRolDaoImpl extends AbstractSession implements UserRolDao {

	@Override
	public UserRol saveUser(UserRol rol) {
		// TODO Auto-generated method stub
		getSession().persist(rol);
		return rol;
	}

	@Override
	public void deleteUser(Long idRol) {
		// TODO Auto-generated method stub
		UserRol rol = findById(idRol);
		if (rol != null) {
			
			getSession().delete(idRol);
		}
	}

	@Override
	public UserRol updateUser(UserRol rol) {
		// TODO Auto-generated method stub
		getSession().update(rol);
		return rol;
	}

	@Override
	public UserRol findById(Long idRol) {
		// TODO Auto-generated method stub
		return getSession().get(UserRol.class, idRol);
	}
	
	@Override
	public List<UserRol> findAllUsers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from UserRol").list();
	}

	@Override
	public UserRol findByName(String descripcion) {
		// TODO Auto-generated method stub
		return (UserRol) getSession().createQuery(
				"from UserRol where descripcion = :descripcion")
				.setParameter("descripcion", descripcion).uniqueResult();
	}
	
	
}
