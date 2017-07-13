package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Codigo;
import org.backoffice.model.Traza;
import org.springframework.data.repository.CrudRepository;

public interface TrazaRepository extends CrudRepository<Traza, Integer> {

	List<Codigo> findById(Integer id);
}
