package com.proyecto.server.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class UserRol implements Serializable{
	
	@Id
	@Column(name="idRol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(name="descripcion")
	private String descripcion;


	
	public UserRol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRol(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
