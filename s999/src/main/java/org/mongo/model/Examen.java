package org.mongo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "examenes")
public class Examen {
	
	@Id
    public String id;
		
	private String nombre;
	
	private int porcentaje;
	
	private Date fechaCreacion;
	
	private int usuarioCreacion;
	
	private List<ExamenPregunta> preguntas = new ArrayList<ExamenPregunta>();
	
	/**
	 * Adds the given {@link Track} to the {@link Album}.
	 * 
	 * @param track
	 */
	public void add(ExamenPregunta tipo) {

		this.preguntas.add(tipo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<ExamenPregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<ExamenPregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	
}
