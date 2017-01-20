package org.servicios;

import java.util.List;

import org.mongo.model.Categoria;
import org.mongo.model.Examen;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.RespuestaUsuario;
import org.mongo.model.Tipo;
import org.mongo.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public interface QuizService {

	public List<Perfil> findByTexto(String texto);
	
	public List<Perfil> findAll();
	
	public List<Pregunta> findByTipo(int tipo);
	
	public List<Pregunta> findAllPreguntas();
	
	public List<Tipo> findAllTipos();
	
	public List<Categoria> findAllCategorias();
	
	public void savePregunta(Pregunta pregunta);
	
	public List<Usuario> findUsuarioByNombre(String nombre);
	
	public List<Examen> findAllExamen();
	
	public void saveExamen(Examen examen);
	
	public Examen findExamen(String id);
	
	public List<Examen> findExamenes(List<String> ids);
	
	public List<Pregunta> findPreguntas(List<String> ids);
	
	public void saveRespuestaUsuario (RespuestaUsuario respuestaUsuario);
	
	public List<RespuestaUsuario> findRespuestasUsuario(String id);
	
	public List<RespuestaUsuario> findByUsuarioExamen(int usuario, String examen);
	
}
