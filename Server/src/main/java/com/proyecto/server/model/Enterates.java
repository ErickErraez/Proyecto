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
@Table(name="enterates")
public class Enterates implements Serializable{
	
	@Id
	@Column(name="idEnt")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEnt;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fecha")
	private String fecha;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAdj")
	private Adjunto adjunto;
	
	

	public Enterates() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Enterates(String titulo, String fecha, Adjunto adjunto) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.adjunto = adjunto;
	}



	public Long getIdEnt() {
		return idEnt;
	}



	public void setIdEnt(Long idEnt) {
		this.idEnt = idEnt;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public Adjunto getAdjunto() {
		return adjunto;
	}



	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}
	
	
}
