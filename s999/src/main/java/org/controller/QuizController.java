package org.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.DatosExamen;
import org.model.DatosLogin;
import org.model.MensajeConfirmacion;
import org.mongo.model.Examen;
import org.mongo.model.ExamenPregunta;
import org.mongo.model.Pregunta;
import org.mongo.model.Usuario;
import org.servicios.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuizController {

	private QuizService quizService;

	@Autowired
	public void setQuizService(QuizService quizService) {
		this.quizService = quizService;
	}

	@RequestMapping(value = "/VistaMenuInicio", method = RequestMethod.POST)
	public String vistaMenuInicio(Model model, HttpSession session, DatosLogin datosLogin) {
		List<Usuario> usuarios = quizService.findUsuarioByNombre(datosLogin.getUsuario());
		if (usuarios.size() > 0) {
			session.setAttribute("usuario", usuarios.get(0));
		}
		if (usuarios.size() > 0 && usuarios.get(0).getContraseña().equalsIgnoreCase(datosLogin.getPassword())) {
			return "VistaMenuInicio";
		} else {
			return "ErrorLogin";
		}
	}

	@RequestMapping(value = "/ConfiguracionExamenes", method = RequestMethod.GET)
	public String ConfiguracionExamenes(Model model, HttpSession session) {

		List<Examen> examenes = quizService.findAllExamen();
		
		model.addAttribute("examenes", examenes);
		
		return "ConfiguracionExamenes";
	}
	
	@RequestMapping(value = "/NuevoExamen", method = RequestMethod.GET)
	public String NuevoExamen(Model model, HttpSession session, DatosExamen datosExamen) {

		List<Pregunta> preguntas = quizService.findAllPreguntas();
		
		model.addAttribute("preguntas", preguntas);
		model.addAttribute("datosExamen", datosExamen);
		
		return "NuevoExamen";
	}
	
	@RequestMapping(value = "/GrabarExamen", method = RequestMethod.POST)
	public String grabarExamen(Model model, HttpSession session, DatosExamen datosExamen, MensajeConfirmacion mensajeConfirmacion) {

		Examen examen = new Examen();
		examen.setNombre(datosExamen.getNombre());
		examen.setPorcentaje(datosExamen.getPorcentaje());
		examen.setFechaCreacion(new Date());
		examen.setUsuarioCreacion(1);
		
		
		String [] preguntas = datosExamen.getComboPreguntas().split(",");
		if(preguntas!=null && preguntas.length>0){
			List<ExamenPregunta> preguntasCombo = new ArrayList <ExamenPregunta>();
			for (int i = 0; i < preguntas.length; i++) {
				ExamenPregunta preguntaCombo = new ExamenPregunta(preguntas[i]);
				preguntasCombo.add(preguntaCombo);
			}
			examen.setPreguntas(preguntasCombo);
		}
		
		try {
			quizService.saveExamen(examen);
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
