package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Codigo;
import org.springframework.data.repository.CrudRepository;

public interface CodigoRepository extends CrudRepository <Codigo, String> {

	List <Codigo> findByCodigo (String codigo);
	
	List <Codigo> findByIdSistema (String idSistema);
	
}
