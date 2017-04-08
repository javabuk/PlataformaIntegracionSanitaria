package org.repositorios;

import java.util.List;

import org.mongo.model.Pregunta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreguntaRepository extends MongoRepository<Pregunta, String> {

	public List<Pregunta> findByTexto(String texto);
	public List<Pregunta> findByTipo(int tipo);
}
