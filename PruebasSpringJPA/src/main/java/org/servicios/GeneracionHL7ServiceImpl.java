package org.servicios;

import org.springframework.stereotype.Service;

@Service
public class GeneracionHL7ServiceImpl implements GeneracionHL7Service {

	@Override
	public String convertirMensajeOML(String texto) {
		texto = texto + " " + texto.toUpperCase();
		return texto;
	}

}
