package org.backoffice.dao;

import java.sql.Timestamp;
import java.util.List;

import org.backoffice.model.Codigo;
import org.backoffice.model.Traza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TrazaRepository extends CrudRepository<Traza, Integer> {

	List<Codigo> findById(Integer id);

	@Query("SELECT t FROM org.backoffice.model.Traza t WHERE t.fecha BETWEEN :from AND :to")
	List<Traza> findTrazasEntreFechas(@Param("from") Timestamp startDay, @Param("to") Timestamp endDay);
}
