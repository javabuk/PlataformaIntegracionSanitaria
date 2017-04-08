package org.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "perfiles")
public class Perfil {

	@Id
    public String id;
	
	public String texto;
	
	public Perfil() {}

    public Perfil(String texto) {
        this.texto = texto;
    }
	
	 @Override
	 public String toString() {
	        return String.format("Perfil[id=%s, texto='%s']",id, texto);
	 }
	
}
