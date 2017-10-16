package org.backoffice.dao;

import java.util.List;

import org.backoffice.model.Codigo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CodigoRepository extends CrudRepository<Codigo, String> {

	List<Codigo> findByCodigo(String codigo);

	List<Codigo> findByDescripcion(String descripcion);

	List<Codigo> findByIdSistema(String idSistema);

	@Query("SELECT count(c.codigo), c.idSistema  FROM org.backoffice.model.Codigo c group by c.idSistema")
	List<Object[]> findDatosCodigos();

	@Query("SELECT c FROM org.backoffice.model.Codigo c WHERE UPPER(c.descripcion) LIKE CONCAT('%',UPPER(:texto),'%')")
	List<Codigo> findCodigosPorDescripcion(@Param("texto") String texto);

}
