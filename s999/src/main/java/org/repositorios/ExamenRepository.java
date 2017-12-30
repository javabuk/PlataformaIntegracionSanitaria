package org.repositorios;

import org.mongo.model.Examen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamenRepository extends MongoRepository<Examen, String> {

}
