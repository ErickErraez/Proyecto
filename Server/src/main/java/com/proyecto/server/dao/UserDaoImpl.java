package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class UserDaoImpl extends AbstractSession implements UserDao {

	@Override
	public AuthModel saveUser(AuthModel usuario) {
		// TODO Auto-generated method stub
		getSession().persist(usuario);
		return usuario;
	}

	@Override
	public void deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		AuthModel usuario = findById(idUser);
		if (usuario != null) {
			
			getSession().delete(usuario);
		}
	}

	@Override
	public AuthModel updateUser(AuthModel usuario) {
		// TODO Auto-generated method stub
		getSession().update(usuario);
		return usuario;
	}

	@Override
	public AuthModel findById(Long idUser) {
		// TODO Auto-generated method stub
		return getSession().get(AuthModel.class, idUser);
	}
	
	@Override
	public List<AuthModel> findAllUsers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from AuthModel").list();
	}

	@Override
	public AuthModel findByName(String userName) {
		// TODO Auto-generated method stub
		return (AuthModel) getSession().createQuery(
				"from AuthModel where userName = :userName")
				.setParameter("userName", userName).uniqueResult();
	}
	
	
}
