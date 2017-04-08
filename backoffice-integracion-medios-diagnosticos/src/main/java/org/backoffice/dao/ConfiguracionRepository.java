package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Configuracion;
import org.springframework.data.repository.CrudRepository;


public interface ConfiguracionRepository extends CrudRepository <Configuracion, Long> {

	List<Configuracion> findByClave(String clave);
		
	
}
