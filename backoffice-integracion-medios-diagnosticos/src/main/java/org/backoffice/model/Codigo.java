package org.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "PSI_CODIGOS")
@IdClass(PkCodigo.class)
public class Codigo {

	@Id
	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Id
	@Column(name = "IDSISTEMA")
	private String idSistema;

	@Id
	@Column(name = "TIPO")
	private String tipo;

	public Codigo() {
	}

	public Codigo(String codigo, String descripcion, String idSistema, String tipo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idSistema = idSistema;
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

	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + ", descripcion=" + descripcion + ", idSistema=" + idSistema + "]";
	}

}
