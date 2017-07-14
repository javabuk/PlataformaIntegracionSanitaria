package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Sistema;
import org.springframework.data.repository.CrudRepository;

public interface SistemaRepository extends CrudRepository<Sistema, String> {

	List<Sistema> findByIdSistema(Integer id);
}
