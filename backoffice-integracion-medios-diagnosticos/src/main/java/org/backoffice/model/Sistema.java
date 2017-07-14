package org.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PSI_SISTEMAS")
public class Sistema {

	@Id
	@Column(name = "IDSISTEMA")
	private String idSistema;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Sistema() {

	}

	public Sistema(String idSistema, String descripcion) {
		super();
		this.idSistema = idSistema;
		this.descripcion = descripcion;
	}

	public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Sistema [idSistema=" + idSistema + ", descripcion=" + descripcion + "]";
	}

}
