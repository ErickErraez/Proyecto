package com.proyecto.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="catalogo")
public class Catalogo implements Serializable{
	
	@Id
	@Column(name="idCat")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCat;
	
	@Column(name="nombre")
	private String nombre;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPdf")
	private Adjunto adjunto;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idBib")
	private Biblioteca biblioteca;
	
	public Catalogo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Catalogo(String nombre, Adjunto adjunto) {
		super();
		this.nombre = nombre;
		this.adjunto = adjunto;
	}


	public Long getIdCat() {
		return idCat;
	}


	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Adjunto getAdjunto() {
		return adjunto;
	}


	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}


	public Biblioteca getBiblioteca() {
		return biblioteca;
	}


	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	

}
