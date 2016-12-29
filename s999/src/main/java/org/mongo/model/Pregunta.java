package org.mongo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preguntas")
public class Pregunta {

	@Id
    public String id;
	
	public String texto;
	
	public String explicacion;
	
	public int tipo;
	
	public int categoria;
	
	public List<Respuesta> respuestas = new ArrayList<Respuesta>();

	public Pregunta(String id, String texto, String explicacion, int tipo, int categoria, List<Respuesta> respuestas) {
		this.id = id;
		this.texto = texto;
		this.explicacion = explicacion;
		this.tipo = tipo;
		this.categoria = categoria;
		this.respuestas = respuestas;
	}
	
	/**
	 * Adds the given {@link Track} to the {@link Album}.
	 * 
	 * @param track
	 */
	public void add(Respuesta respuesta) {

		this.respuestas.add(respuesta);
	}


	/**
	 * Returns the number of {@link Track}s contained in the {@link Album}.
	 * 
	 * @return
	 */
	public int trackCount() {

		return this.respuestas.size();
	}

	
	 @Override
	 public String toString() {
	        return String.format("Repuesta[id=%s, texto='%s', respuesta='%s']",id, texto, respuestas.get(0).respuesta);
	 }
	
}
