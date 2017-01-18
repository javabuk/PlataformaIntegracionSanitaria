package org.repositorios;

import java.util.List;

import org.mongo.model.RespuestaUsuario;
import org.mongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RespuestaUsuarioRepository extends MongoRepository<RespuestaUsuario, String> {
	public List<RespuestaUsuario> findByUsuario(String usuario);
}
