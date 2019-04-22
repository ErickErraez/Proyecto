package com.proyecto.server.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
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
@Table(name="Eventos")
public class Events implements Serializable{
	
	@Id
	@Column(name="idEvent")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvent;
	
	@Column(name="title")
	private String title;
	
	@Column(name="tipo")
	private String tipo;
	 
	@Column(name="backgroundColor")
	private String backgroundColor;

	@Column(name="start") 
	private String start;
	
	@Column(name="end")
	private String end;

	
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Events(String title, String start, String end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
	}


	public Long getIdEvent() {
		return idEvent;
	}


	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}


	public String getTitle() {
		return title;
	}


	public String getBackgroundColor() {
		return backgroundColor;
	}


	public void setBackground(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}

	
}
