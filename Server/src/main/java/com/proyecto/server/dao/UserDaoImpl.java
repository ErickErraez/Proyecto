package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.proyecto.server.model.Usuarios;


@Repository
@Transactional
public class UserDaoImpl extends AbstractSession implements UserDao {

	@Override
	public Usuarios saveUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		getSession().persist(usuario);
		return usuario;
	}

	@Override
	public void deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		Usuarios usuario = findById(idUser);
		if (usuario != null) {
			
			getSession().delete(usuario);
		}
	}

	@Override
	public Usuarios updateUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		getSession().update(usuario);
		return usuario;
	}

	@Override
	public Usuarios findById(Long idUser) {
		// TODO Auto-generated method stub
		return getSession().get(Usuarios.class, idUser);
	}
	
	@Override
	public List<Usuarios> findAllUsers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Usuarios").list();
	}

	@Override
	public Usuarios findByName(String nombre) {
		// TODO Auto-generated method stub
		return (Usuarios) getSession().createQuery(
				"from Usuarios where nombre = :nombre")
				.setParameter("nombre", nombre).uniqueResult();
	}
	
	
}
