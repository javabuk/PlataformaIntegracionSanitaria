package org.repositorios;

import java.util.List;

import org.mongo.model.RespuestaUsuario;
import org.mongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RespuestaUsuarioRepository extends MongoRepository<RespuestaUsuario, String> {
	public List<RespuestaUsuario> findByUsuario(String usuario);
	@Query(value = "{ 'usuario' : ?0, 'examen' : ?1 }")
	public List<RespuestaUsuario> findByUsuarioExamen(int usuario, String examen);
	
}
