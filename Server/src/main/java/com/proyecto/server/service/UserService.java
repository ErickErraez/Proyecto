package com.proyecto.server.service;
import java.util.List;

import com.proyecto.server.model.AuthModel;
import com.proyecto.server.model.Usuarios;

public interface UserService {
	
	AuthModel saveUser(AuthModel usuario);
	
	void deleteUser(Long idUser);
	
	AuthModel updateUser(AuthModel usuario);
	
	AuthModel findById(Long idUser);
	
	List<AuthModel> findAllUsers();
	
	AuthModel findByName(String nombre);

}
