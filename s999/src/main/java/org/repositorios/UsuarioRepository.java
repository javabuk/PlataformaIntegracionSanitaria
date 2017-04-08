package org.repositorios;

import java.util.List;

import org.mongo.model.Perfil;
import org.mongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String>  {
	public List<Usuario> findByNombre(String nombre);
}
