package org.model;

import java.util.Date;


public class DatosExamen {
	
    public int id;
		
	private String nombre;
	
	private int porcentaje;
	
	private Date fechaCreacion;
	
	private int usuarioCreacion;
	
	private String comboPreguntas;

	public DatosExamen() {
		super();
	}

	public DatosExamen(int id, String nombre, int porcentaje, Date fechaCreacion, int usuarioCreacion,
			String comboPreguntas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.comboPreguntas = comboPreguntas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(int usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getComboPreguntas() {
		return comboPreguntas;
	}

	public void setComboPreguntas(String comboPreguntas) {
		this.comboPreguntas = comboPreguntas;
	}
	
}
