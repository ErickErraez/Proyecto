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
@Table(name="aplicaciones")
public class Aplicaciones implements Serializable{
	
	@Id
	@Column(name="idApp")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idApp;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="link")
	private String link;
	
	@Column(name="tipo")
	private String tipo;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "idImagen")
	private Adjunto adjunto;
	
	

	public Aplicaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Aplicaciones(String nombre, String link, Adjunto adjunto) {
		super();
		this.nombre = nombre;
		this.link = link;
		this.adjunto = adjunto;
	}



	public Long getIdApp() {
		return idApp;
	}

	public void setIdApp(Long idApp) {
		this.idApp = idApp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Adjunto getAdjunto() {
		return adjunto;
	}


	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}


	
	
}
