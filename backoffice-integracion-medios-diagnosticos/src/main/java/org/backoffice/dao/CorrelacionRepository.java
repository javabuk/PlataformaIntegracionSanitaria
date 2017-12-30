package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Correlacion;
import org.springframework.data.repository.CrudRepository;

public interface CorrelacionRepository extends CrudRepository<Correlacion, String> {

	List<Correlacion> findByCodigoA(String codigo);

	List<Correlacion> findByCodigoB(String codigo);
}
