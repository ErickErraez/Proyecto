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
@Table(name="biblioteca")
public class Biblioteca implements Serializable{
	
	@Id
	@Column(name="idBib")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBib;
	
	@Column(name="nombre")
	private String nombre;
	
	

	public Biblioteca() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Biblioteca(String nombre, String link, Catalogo catalogo) {
		super();
		this.nombre = nombre;
	}


	public Long getIdBib() {
		return idBib;
	}


	public void setIdBib(Long idBib) {
		this.idBib = idBib;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
