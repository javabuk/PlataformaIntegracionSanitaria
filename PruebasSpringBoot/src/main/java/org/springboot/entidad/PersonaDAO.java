package org.springboot.entidad;


import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Transactional
@Component("PersonaDAO")
public interface PersonaDAO extends CrudRepository<Persona, Long> { 

	
}
