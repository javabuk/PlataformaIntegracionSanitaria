package org.backoffice.model;

import java.io.Serializable;

public class BusquedaGeneralDTO implements Serializable {

	
	private static final long serialVersionUID = -4864465275424113145L;

	private String tipo;
	private String codigo;
	private String descripcion;
	
	public BusquedaGeneralDTO(){
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
