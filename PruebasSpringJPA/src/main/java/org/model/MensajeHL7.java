package org.model;

public class MensajeHL7 {
	
	private String mensaje;
	private String sistemaOrigen;
	private String sistemaDestino;
	

	public String getSistemaOrigen() {
		return sistemaOrigen;
	}

	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	public String getSistemaDestino() {
		return sistemaDestino;
	}

	public void setSistemaDestino(String sistemaDestino) {
		this.sistemaDestino = sistemaDestino;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
