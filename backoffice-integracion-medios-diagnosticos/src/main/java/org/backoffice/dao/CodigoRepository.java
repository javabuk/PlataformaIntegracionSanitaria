package org.backoffice.dao;

import java.sql.Timestamp;
import java.util.List;

import org.backoffice.model.Codigo;
import org.backoffice.model.Traza;
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
	
	@Query("SELECT c FROM org.backoffice.model.Codigo c WHERE c.idSistema = :sistema and c.tipo = :tipo ")
	//@Query("SELECT c FROM org.backoffice.model.Codigo c, org.backoffice.model.Correlacion cor WHERE c.idSistema = :sistema and c.tipo = :tipo AND c.idSistema = cor.sistemaA AND c.tipo = cor.tipoA AND cor.sistemaB = 'LAFITA' ")
	List<Codigo> findCodigosSistemaTipo(@Param("sistema") String sistema, @Param("tipo") String tipo);

}
