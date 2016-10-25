package org.repositorios;

import java.util.List;

import org.model.ConfigMensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

//@Component
//public interface ConfigMensajeRepositorio extends CrudRepository<ConfigMensaje, Long> {
public interface ConfigMensajeRepositorio  {

	List<ConfigMensaje> findByMensajeOrigen(String mensajeOrigen);
	
}
