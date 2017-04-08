package org.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONFIG_MENSAJES database table.
 * 
 */
//@Entity 
@Table(name="CONFIG_MENSAJES")
@NamedQuery(name="ConfigMensaje.findAll", query="SELECT c FROM ConfigMensaje c")
public class ConfigMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = true)
	private int id;

	@Column(name="CORRELACION_CODIGOS")
	private int correlacionCodigos;

	@Column(name="MENSAJE_ORIGEN")
	private String mensajeOrigen;

	@Column(name="SISTEMA_DESTINO")
	private String sistemaDestino;

	@Column(name="SISTEMA_ORIGEN")
	private String sistemaOrigen;

	@Column(name="TIPO_TRAZABILIDAD")
	private int tipoTrazabilidad;

	@Column(name="TRADUCCION_MENSAJE")
	private String traduccionMensaje;

	public ConfigMensaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCorrelacionCodigos() {
		return this.correlacionCodigos;
	}

	public void setCorrelacionCodigos(int correlacionCodigos) {
		this.correlacionCodigos = correlacionCodigos;
	}

	public String getMensajeOrigen() {
		return this.mensajeOrigen;
	}

	public void setMensajeOrigen(String mensajeOrigen) {
		this.mensajeOrigen = mensajeOrigen;
	}

	public String getSistemaDestino() {
		return this.sistemaDestino;
	}

	public void setSistemaDestino(String sistemaDestino) {
		this.sistemaDestino = sistemaDestino;
	}

	public String getSistemaOrigen() {
		return this.sistemaOrigen;
	}

	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	public int getTipoTrazabilidad() {
		return this.tipoTrazabilidad;
	}

	public void setTipoTrazabilidad(int tipoTrazabilidad) {
		this.tipoTrazabilidad = tipoTrazabilidad;
	}

	public String getTraduccionMensaje() {
		return this.traduccionMensaje;
	}

	public void setTraduccionMensaje(String traduccionMensaje) {
		this.traduccionMensaje = traduccionMensaje;
	}

}