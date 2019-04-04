package com.proyecto.server.dao;

import java.util.List;

import com.proyecto.server.model.UserRol;

public interface UserRolDao {

	UserRol saveUser(UserRol rol);

	void deleteUser(Long idRol);

	UserRol updateUser(UserRol rol);

	UserRol findById(Long idRol);

	List<UserRol> findAllUsers();

	UserRol findByName(String nombre);

}
