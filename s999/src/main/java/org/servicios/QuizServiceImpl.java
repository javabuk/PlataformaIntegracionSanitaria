package org.servicios;

import java.util.List;

import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.repositorios.ConfigMensajeRepositorio;
import org.repositorios.PerfilRepository;
import org.repositorios.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	
	private PerfilRepository perfilRepository;
	private PreguntaRepository preguntaRepository;

    @Autowired
    public void setPerfilRepository(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }
    
    @Autowired
    public void setPreguntaRepository(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }
	
	@Override
	public List<Perfil> findByTexto(String texto) {
		return this.perfilRepository.findByTexto(texto);
	}

	@Override
	public List<Perfil> findAll() {
		
		return this.perfilRepository.findAll();
	}

	@Override
	public List<Pregunta> findByTipo(int tipo) {
		return this.preguntaRepository.findByTipo(tipo);
	}

	@Override
	public List<Pregunta> findAllPreguntas() {
		return this.preguntaRepository.findAll();
	}

}
