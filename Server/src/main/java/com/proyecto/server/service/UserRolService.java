package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.UserRol;
import com.proyecto.server.model.Usuarios;

public interface UserRolService {
	
	UserRol saveUser(UserRol rol);
	
	void deleteUser(Long idRol);
	
	UserRol updateUser(UserRol rol);
	
	UserRol findById(Long idRol);
	
	List<UserRol> findAllUsers();
	
	UserRol findByName(String nombre);

}
