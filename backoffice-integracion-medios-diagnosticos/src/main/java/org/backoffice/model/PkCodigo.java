package org.backoffice.model;

import java.io.Serializable;

public class PkCodigo implements Serializable {

	private static final long serialVersionUID = 5857460183774838547L;

	private String codigo;
	private String idSistema;
	private String tipo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
