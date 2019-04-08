package com.proyecto.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="adjunto")
public class Adjunto implements Serializable{
	
	@Id
	@Column(name="idAdj")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdj;
	
	@Column(name="tipoArchivo")
	private String tipoArchivo;
	
	@Column(name="nombreArchivo")
	private String nombreArchivo;
	
	@Column(name="adjuntoArchivo")
	private String adjuntoArchivo;

	public Adjunto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adjunto(String tipoArchivo, String nombreArchivo, String adjuntoArchivo) {
		super();
		this.tipoArchivo = tipoArchivo;
		this.nombreArchivo = nombreArchivo;
		this.adjuntoArchivo = adjuntoArchivo;
	}

	public Long getIdAdj() {
		return idAdj;
	}

	public void setIdAdj(Long idAdj) {
		this.idAdj = idAdj;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getAdjuntoArchivo() {
		return adjuntoArchivo;
	}

	public void setAdjuntoArchivo(String adjuntoArchivo) {
		this.adjuntoArchivo = adjuntoArchivo;
	}
	
	
	

}
