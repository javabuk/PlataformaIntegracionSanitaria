package org.controller;

import java.util.List;

import org.model.DatosLogin;
import org.mongo.model.Perfil;
import org.mongo.model.Pregunta;
import org.mongo.model.PreguntasConsulta;
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
    String vistaGeneral(Model model, DatosLogin datosLogin, List<Perfil> perfiles, @ModelAttribute PreguntasConsulta preguntas){
    	if(datosLogin.getUsuario().equalsIgnoreCase("jorge")){
    		
    		perfiles  =quizService.findAll();
    		System.out.println("Perfiles ///////////////");
    		System.out.println("Perfiles " + perfiles.size());
    		System.out.println("Perfiles ///////////////");
    		
    		preguntas.setPreguntas(quizService.findAllPreguntas());
    		
    		model.addAttribute("datosLogin", datosLogin);
    		model.addAttribute("perfiles", perfiles);
    		model.addAttribute("preguntas", preguntas);
    		return "VistaGeneral_Quiz";
    	}else{
    		return "ErrorLogin";
    	}
    }
    
}
