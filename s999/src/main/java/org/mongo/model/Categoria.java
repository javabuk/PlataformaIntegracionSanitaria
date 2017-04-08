package org.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class Categoria {
	
	@Id
    public String id;
	
	public int id_tipo;
	
	public String descripcion;
	
	public Categoria() {}

    public Categoria(String descripcion, int id_tipo) {
        this.descripcion = descripcion;
        this.id_tipo = id_tipo;
    }
	
	 @Override
	 public String toString() {
	        return String.format("Categoria[id=%s, descripcion='%s']",id, descripcion);
	 }
}
