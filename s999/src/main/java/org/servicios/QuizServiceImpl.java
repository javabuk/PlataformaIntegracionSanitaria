package org.servicios;

import java.util.List;

import org.mongo.model.Categoria;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.Tipo;
import org.repositorios.CategoriaRepository;
import org.repositorios.ConfigMensajeRepositorio;
import org.repositorios.PerfilRepository;
import org.repositorios.PreguntaRepository;
import org.repositorios.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	
	private PerfilRepository perfilRepository;
	private PreguntaRepository preguntaRepository;
	private TipoRepository tipoRepository;
	private CategoriaRepository categoriaRepository;

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
	
	@Autowired
    public void setTipoRepository(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }
	
	@Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
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

	@Override
	public List<Tipo> findAllTipos() {
		return this.tipoRepository.findAll();
	}

	@Override
	public List<Categoria> findAllCategorias() {
		return this.categoriaRepository.findAll();
	}

	@Override
	public void savePregunta(Pregunta pregunta) {
		this.preguntaRepository.save(pregunta);		
	}

}
