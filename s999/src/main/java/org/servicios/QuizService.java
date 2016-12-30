package org.servicios;

import java.util.List;

import org.mongo.model.Categoria;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.Tipo;
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
	
}
