package org.repositorios;

import java.util.List;

import org.mongo.model.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {

	public List<Perfil> findByTexto(String texto);
	
}
