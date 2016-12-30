package org.repositorios;

import java.util.List;

import org.mongo.model.Tipo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoRepository extends MongoRepository<Tipo, String> {

	public List<Tipo> findByDescripcion(String descripcion);
	
}
