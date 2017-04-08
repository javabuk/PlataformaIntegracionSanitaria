package org.servicios;

import java.util.List;

import org.mongo.model.Categoria;
import org.mongo.model.Examen;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.RespuestaUsuario;
import org.mongo.model.Tipo;
import org.mongo.model.Usuario;
import org.repositorios.CategoriaRepository;
import org.repositorios.ConfigMensajeRepositorio;
import org.repositorios.ExamenRepository;
import org.repositorios.PerfilRepository;
import org.repositorios.PreguntaRepository;
import org.repositorios.RespuestaUsuarioRepository;
import org.repositorios.TipoRepository;
import org.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	
	private PerfilRepository perfilRepository;
	private PreguntaRepository preguntaRepository;
	private TipoRepository tipoRepository;
	private CategoriaRepository categoriaRepository;
	private UsuarioRepository usuarioRepository;
	private ExamenRepository examenRepository;
	private RespuestaUsuarioRepository respuestaUsuarioRepository;
	

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
	
	@Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
	
	@Autowired
    public void setExamenRepository(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }
	
	@Autowired
    public void setRespuestaUsuarioRepository(RespuestaUsuarioRepository respuestaUsuarioRepository) {
        this.respuestaUsuarioRepository = respuestaUsuarioRepository;
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

	@Override
	public List<Usuario> findUsuarioByNombre(String nombre) {
		return this.usuarioRepository.findByNombre(nombre);
	}

	@Override
	public List<Examen> findAllExamen() {
		return this.examenRepository.findAll();
	}

	@Override
	public void saveExamen(Examen examen) {
		this.examenRepository.save(examen);
	}

	@Override
	public Examen findExamen(String id) {
		
		return this.examenRepository.findOne(id);
	}

	@Override
	public List<Examen> findExamenes(List<String> ids) {
		
		return (List<Examen>) this.examenRepository.findAll(ids);
	}

	@Override
	public List<Pregunta> findPreguntas(List<String> ids) {
		return (List<Pregunta>) this.preguntaRepository.findAll(ids);
	}

	@Override
	public void saveRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
		this.respuestaUsuarioRepository.save(respuestaUsuario);
	}

	@Override
	public List<RespuestaUsuario> findRespuestasUsuario(String id) {
		return this.respuestaUsuarioRepository.findByUsuario(id);
	}

	@Override
	public List<RespuestaUsuario> findByUsuarioExamen(int usuario, String examen) {
		
		return this.respuestaUsuarioRepository.findByUsuarioExamen(usuario, examen);
	}

}
