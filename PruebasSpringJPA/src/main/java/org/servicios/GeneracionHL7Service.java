package org.servicios;

import org.model.MensajeHL7;

public interface GeneracionHL7Service {
	
	public String convertirMensajeOML(String sistemaOrigen, String sistemaDestino, String texto);

	public String convertirMensajeOML(MensajeHL7 mensajeHL7);
}
