package org.springboot.repositorios;

import org.springboot.entidad.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface RepositorioPersonas extends CrudRepository<Persona, Integer> {

}
