package org.mongo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "respuestasUsuario")
public class RespuestaUsuario {
	
	@Id
    private String id;
		
	private int usuario;
	
	private String examen;
	
	private int porcentaje;
	
	private int porcentajeRealizado;
	
	private Date fechaRealizacion;

	private List<ErroresUsuario> errores = new ArrayList<ErroresUsuario>();
	
	/**
	 * Adds the given {@link Track} to the {@link Album}.
	 * 
	 * @param track
	 */
	public void add(ErroresUsuario error) {

		this.errores.add(error);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getExamen() {
		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public List<ErroresUsuario> getErrores() {
		return errores;
	}

	public void setErrores(List<ErroresUsuario> errores) {
		this.errores = errores;
	}

	public int getPorcentajeRealizado() {
		return porcentajeRealizado;
	}

	public void setPorcentajeRealizado(int porcentajeRealizado) {
		this.porcentajeRealizado = porcentajeRealizado;
	}
	
	

}
