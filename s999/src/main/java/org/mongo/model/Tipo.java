package org.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipos")
public class Tipo {
	
	@Id
    public String id;
	
	public String descripcion;
	
	public Tipo() {}

    public Tipo(String descripcion) {
        this.descripcion = descripcion;
    }
	
	 @Override
	 public String toString() {
	        return String.format("Perfil[id=%s, descripcion='%s']",id, descripcion);
	 }

}
