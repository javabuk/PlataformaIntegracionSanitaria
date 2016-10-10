package org.springboot.general;

import java.util.concurrent.atomic.AtomicLong;

import org.springboot.entidad.Persona;


import org.springboot.entidad.PersonaDAO;

import org.springboot.entidad.Respuesta;

import org.springboot.repositorios.RepositorioPersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class AplicacionController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    


    private RepositorioPersonas personaDao;
    
    @Autowired
    public void setRepositorioPersonas(RepositorioPersonas personaRepositorio) {
        this.personaDao = personaRepositorio;
    }


    @RequestMapping("/greeting")
    public Respuesta greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
    	Persona persona = new Persona();
    	persona.setAddress("Address");
    	persona.setCity("City");
    	persona.setFirstName("PrimerApellido");
    	persona.setLastName("Segundo apellido");
    	
    	personaDao.save(persona);
    	
    	
    	Respuesta resp = new Respuesta();
    	resp.setCodigo(100);
    	resp.setDescripcion("Prueba" + counter.getAndIncrement());
    	
    	
    	return resp;
    }

}
