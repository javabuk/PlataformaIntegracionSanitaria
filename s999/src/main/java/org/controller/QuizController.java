package org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.DatosLogin;
import org.mongo.model.Examen;
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
}
