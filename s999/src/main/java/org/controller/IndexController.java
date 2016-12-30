package org.controller;

import java.util.ArrayList;
import java.util.List;

import org.model.DatosLogin;
import org.model.DatosPregunta;
import org.model.MensajeConfirmacion;
import org.model.MensajeHL7;
import org.mongo.model.Categoria;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.PreguntasConsulta;
import org.mongo.model.Respuesta;
import org.mongo.model.Tipo;
import org.repositorios.PerfilRepository;
import org.servicios.GeneracionHL7Service;
import org.servicios.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



 
@Controller
public class IndexController {
 
	private QuizService quizService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
	
	
    @RequestMapping("/")
    String index(){
        return "Login";
    }
    
    @RequestMapping(value = "/VistaGeneral" , method = RequestMethod.POST)
    String vistaGeneral(Model model, DatosLogin datosLogin, List<Perfil> perfiles, @ModelAttribute PreguntasConsulta preguntas, List<Tipo> tipos, List<Categoria> categorias){
    	if(datosLogin.getUsuario().equalsIgnoreCase("jorge")){
    		
    		perfiles  = quizService.findAll();
    		tipos = quizService.findAllTipos();
    		categorias = quizService.findAllCategorias();
    		System.out.println("Perfiles ///////////////");
    		System.out.println("Perfiles " + perfiles.size());
    		System.out.println("Perfiles ///////////////");
    		// Objeto para utilizar en el formulario para registrar preguntas.
    		DatosPregunta datosPregunta = new DatosPregunta();
    		
    		preguntas.setPreguntas(quizService.findAllPreguntas());
    		
    		model.addAttribute("datosLogin", datosLogin);
    		model.addAttribute("perfiles", perfiles);
    		model.addAttribute("tipos", tipos);
    		model.addAttribute("categorias", categorias);
    		model.addAttribute("preguntas", preguntas);
    		model.addAttribute("datosPregunta", datosPregunta);
    		
    		return "VistaGeneral_Quiz";
    	}else{
    		return "ErrorLogin";
    	}
    }
    
    
    @RequestMapping(value = "/ResultadoOperacion", method = RequestMethod.POST)
	public String ResultadoMensajesHL7(Model model, DatosPregunta datosPregunta,MensajeConfirmacion mensajeConfirmacion) {
		
    	//MensajeConfirmacion mensajeConfirmacion = new MensajeConfirmacion();
		Pregunta pregunta = new Pregunta();
		
		if(datosPregunta.texto!=null){
			pregunta.texto = datosPregunta.texto;
		}
		
		if(datosPregunta.explicacion != null){
			pregunta.explicacion = datosPregunta.explicacion;
		}
		
    	pregunta.tipo = datosPregunta.tipo;
    	pregunta.categoria = datosPregunta.categoria;
    	
    	List<Respuesta> respuestas = new ArrayList<Respuesta>();
    	
    	Respuesta respuestaCorrecta = new Respuesta(datosPregunta.respuestaCorrecta, true);
    	respuestas.add(respuestaCorrecta);
    	
    	if(datosPregunta.respuestaErronea1 != null){
    		Respuesta respuestaErronea1 = new Respuesta(datosPregunta.respuestaErronea1, false);
        	respuestas.add(respuestaErronea1);
    	}
    	if(datosPregunta.respuestaErronea2 != null){
    		Respuesta respuestaErronea2 = new Respuesta(datosPregunta.respuestaErronea2, false);
        	respuestas.add(respuestaErronea2);
    	}
    	if(datosPregunta.respuestaErronea3 != null){
    		Respuesta respuestaErronea3 = new Respuesta(datosPregunta.respuestaErronea3, false);
        	respuestas.add(respuestaErronea3);
    	}
    	if(datosPregunta.respuestaErronea4 != null){
    		Respuesta respuestaErronea4 = new Respuesta(datosPregunta.respuestaErronea4, false);
        	respuestas.add(respuestaErronea4);
    	}
    	if(datosPregunta.respuestaErronea5 != null){
    		Respuesta respuestaErronea5 = new Respuesta(datosPregunta.respuestaErronea5, false);
        	respuestas.add(respuestaErronea5);
    	}
    	if(datosPregunta.respuestaErronea6 != null){
    		Respuesta respuestaErronea6 = new Respuesta(datosPregunta.respuestaErronea6, false);
        	respuestas.add(respuestaErronea6);
    	}
    	pregunta.respuestas = respuestas;
    	
    	try {
			quizService.savePregunta(pregunta);
			mensajeConfirmacion.setMensaje("Insercion correcta");
		} catch (Exception e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		}
    	
    	model.addAttribute("mensaje", mensajeConfirmacion);
		return "ConfirmacionOperacion";
	}
    
}
