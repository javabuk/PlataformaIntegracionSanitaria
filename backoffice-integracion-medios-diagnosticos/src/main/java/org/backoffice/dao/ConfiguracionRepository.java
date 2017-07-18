package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Configuracion;

//public interface ConfiguracionRepository extends CrudRepository <Configuracion, Long> {
public interface ConfiguracionRepository {
	List<Configuracion> findByClave(String clave);

}
