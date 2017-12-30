package org.mongo.model;

public class UsuarioPerfil {
	
	int id_tipo;
	
	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public UsuarioPerfil() {
		super();
	}

	public UsuarioPerfil(int id_perfil) {
		super();
		this.id_tipo= id_perfil;
	}
	
	

}
