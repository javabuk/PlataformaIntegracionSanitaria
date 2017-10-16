package org.backoffice.dao;

import java.util.List;

import org.backoffice.fuentedatos.DatosCodigosDTO;
import org.backoffice.model.Codigo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CodigoRepository extends CrudRepository <Codigo, String> {

	List <Codigo> findByCodigo (String codigo);
	
	List <Codigo> findByDescripcion (String descripcion);
	
	List <Codigo> findByIdSistema (String idSistema);
	
	@Query("SELECT count(c.codigo), c.idSistema  FROM org.backoffice.model.Codigo c group by c.idSistema")
	List<Object []> findDatosCodigos();
	
}
