package org.mongo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

	@Id
    public int id;
	
	public String nombre;
	
	public String contraseña;
	
	public int perfil;

	public List<UsuarioPerfil> tipos = new ArrayList<UsuarioPerfil>();

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String contraseña, int perfil, List<UsuarioPerfil> tipos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.perfil = perfil;
		this.tipos = tipos;
	}
	
	/**
	 * Adds the given {@link Track} to the {@link Album}.
	 * 
	 * @param track
	 */
	public void add(UsuarioPerfil tipo) {

		this.tipos.add(tipo);
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public List<UsuarioPerfil> getTipos() {
		return tipos;
	}

	public void setTipos(List<UsuarioPerfil> tipos) {
		this.tipos = tipos;
	}
	
	
}
