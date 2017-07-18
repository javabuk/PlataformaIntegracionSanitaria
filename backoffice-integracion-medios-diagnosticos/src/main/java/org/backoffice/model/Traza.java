package org.backoffice.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PSI_TRAZAS")
public class Traza {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ID_MENSAJE")
	private String idMensaje;

	@Column(name = "SIST_MENSAJE")
	private String sistMensaje;

	@Column(name = "MENSAJE")
	private String mensaje;

	@Column(name = "FECHA")
	private Timestamp fecha;

	@Column(name = "MODULO")
	private String modulo;

	@Column(name = "DESTINO")
	private String destino;

	@Column(name = "ERROR")
	private String error;

	public Traza() {
	}

	public Traza(Integer id, String idMensaje, String sistMensaje, String mensaje, Timestamp fecha, String modulo,
			String destino, String error) {
		super();
		this.id = id;
		this.idMensaje = idMensaje;
		this.sistMensaje = sistMensaje;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.modulo = modulo;
		this.destino = destino;
		this.error = error;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSistMensaje() {
		return sistMensaje;
	}

	public void setSistMensaje(String sistMensaje) {
		this.sistMensaje = sistMensaje;
	}

	@Override
	public String toString() {
		return "Traza [id=" + id + ", idMensaje=" + idMensaje + ", mensaje=" + mensaje + ", fecha=" + fecha
				+ ", modulo=" + modulo + ", destino=" + destino + ", error=" + error + "]";
	}

}
