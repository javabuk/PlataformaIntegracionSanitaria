package org.backoffice.model;

import java.io.Serializable;

public class BusquedaGeneralDTO implements Serializable {

	private static final long serialVersionUID = -4864465275424113145L;

	private String tipo;
	private String codigo;
	private String descripcion;
	private String tipoCodigo;
	private String sistema;
	private String codigoB;
	private String tipoCodigoB;
	private String sistemaB;

	private String idMensaje;
	private String mensaje;
	private String fechaTraza;
	private String errorTraza;

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

	public String getCodigoB() {
		return codigoB;
	}

	public void setCodigoB(String codigoB) {
		this.codigoB = codigoB;
	}

	public String getTipoCodigoB() {
		return tipoCodigoB;
	}

	public void setTipoCodigoB(String tipoCodigoB) {
		this.tipoCodigoB = tipoCodigoB;
	}

	public String getSistemaB() {
		return sistemaB;
	}

	public void setSistemaB(String sistemaB) {
		this.sistemaB = sistemaB;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFechaTraza() {
		return fechaTraza;
	}

	public void setFechaTraza(String fechaTraza) {
		this.fechaTraza = fechaTraza;
	}

	public String getErrorTraza() {
		return errorTraza;
	}

	public void setErrorTraza(String errorTraza) {
		this.errorTraza = errorTraza;
	}

}
