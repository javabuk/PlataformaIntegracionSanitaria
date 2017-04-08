package org.mongo.model;

public class ErroresUsuario {

	private String id_pregunta;

	public ErroresUsuario() {
		super();
	}

	public ErroresUsuario(String id_pregunta) {
		super();
		this.id_pregunta = id_pregunta;
	}

	public String getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(String id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
}
