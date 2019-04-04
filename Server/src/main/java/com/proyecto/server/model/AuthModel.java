package com.proyecto.server.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users")
public class AuthModel implements Serializable{
	
	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name="userName")
	private String user;
	
	@Column(name="userPass")
	
	private String password;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	private UserRol userRol;


	public AuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AuthModel(String user, UserRol userRol) {
		super();
		this.user = user;
		this.userRol = userRol;
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public UserRol getUserRol() {
		return userRol;
	}

	public void setUserRol(UserRol userRol) {
		this.userRol = userRol;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
		
	}

	

}
