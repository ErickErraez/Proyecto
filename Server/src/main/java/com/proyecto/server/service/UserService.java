package com.proyecto.server.service;
import java.util.List;
import com.proyecto.server.model.Usuarios;

public interface UserService {
	
	Usuarios saveUser(Usuarios usuario);
	
	void deleteUser(Long idUser);
	
	Usuarios updateUser(Usuarios usuario);
	
	Usuarios findById(Long idUser);
	
	List<Usuarios> findAllUsers();
	
	Usuarios findByName(String nombre);

}
