package org.servicios;

import java.util.List;

import org.model.ConfigMensaje;

public interface ConfiguracionService {
	
	List<ConfigMensaje> findByMensajeOrigen(String mensajeOrigen);

}
