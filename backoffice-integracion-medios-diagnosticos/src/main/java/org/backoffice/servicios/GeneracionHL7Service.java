package org.backoffice.servicios;

import org.backoffice.model.MensajeHL7;

public interface GeneracionHL7Service {

	public String convertirMensajeOML(String sistemaOrigen, String sistemaDestino, String texto);

	public String convertirMensajeOML(MensajeHL7 mensajeHL7);

	public String convertirMensajeOMG(MensajeHL7 mensajeHL7);
}
