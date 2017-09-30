package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Sistema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SistemaRepository extends CrudRepository<Sistema, String> {

	List<Sistema> findByIdSistema(Integer id);

	List<Sistema> findByDescripcion(String descripcion);

	@Query("SELECT t FROM org.backoffice.model.Sistema t WHERE t.idSistema = :idSistema and  t.descripcion = :descripcion")
	List<Sistema> findSistemas(@Param("idSistema") String idSistema, @Param("descripcion") String descripcion);
}
