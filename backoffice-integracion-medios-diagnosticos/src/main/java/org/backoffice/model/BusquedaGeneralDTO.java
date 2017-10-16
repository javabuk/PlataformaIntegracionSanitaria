package org.backoffice.model;

import java.io.Serializable;

public class BusquedaGeneralDTO implements Serializable {

	private static final long serialVersionUID = -4864465275424113145L;

	private String tipo;
	private String codigo;
	private String descripcion;
	private String tipoCodigo;
	private String sistema;

	public BusquedaGeneralDTO() {

	}

	public String getTipoCodigo() {
		return tipoCodigo;
	}

	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
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
