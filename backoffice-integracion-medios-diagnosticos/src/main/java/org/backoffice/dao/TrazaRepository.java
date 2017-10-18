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

	@Query("SELECT t FROM org.backoffice.model.Traza t WHERE t.sistMensaje = :sistema ")
	List<Traza> findTrazasPorSistema(@Param("sistema") String sistema);

	@Query("SELECT t FROM org.backoffice.model.Traza t WHERE t.sistMensaje = :sistema AND t.fecha BETWEEN :from AND :to")
	List<Traza> findTrazasPorSistemaEntreFechas(@Param("sistema") String sistema, @Param("from") Timestamp startDay,
			@Param("to") Timestamp endDay);

	@Query("SELECT count(t.id), FUNCTION ('TO_CHAR',t.fecha,'YYYY-MM-DD') FROM org.backoffice.model.Traza t group by FUNCTION ('TO_CHAR',t.fecha,'YYYY-MM-DD')")
	List<Object[]> findTrazasPorDia();

	@Query("SELECT count(t.id), FUNCTION ('TO_CHAR',t.fecha,'YYYY-MM-DD'), t.sistMensaje FROM org.backoffice.model.Traza t group by FUNCTION ('TO_CHAR',t.fecha,'YYYY-MM-DD'), t.sistMensaje")
	List<Object[]> findTrazasPorDiaPorSistema();

	@Query("SELECT t FROM org.backoffice.model.Traza t WHERE t.sistMensaje = :sistema and UPPER(t.idMensaje) LIKE CONCAT('%',UPPER(:idMensaje),'%')")
	List<Traza> findTrazasPorSistemaeIdMensaje(@Param("sistema") String sistema, @Param("idMensaje") String idMensaje);

	@Query("SELECT t FROM org.backoffice.model.Traza t WHERE  UPPER(t.mensaje) LIKE CONCAT('%',UPPER(:descripcion),'%')")
	List<Traza> findTrazasPorDescripcionLike(@Param("descripcion") String descripcion);

}
