package org.servicios;

public interface GeneracionHL7Service {
	
	public String convertirMensajeOML(String sistemaOrigen, String sistemaDestino, String texto);

}
