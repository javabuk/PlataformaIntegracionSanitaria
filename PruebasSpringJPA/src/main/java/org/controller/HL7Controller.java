package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HL7Controller {

	
	@RequestMapping(value = "/FormularioHL7", method = RequestMethod.GET)
	public String list(Model model) {
		return "FormularioHL7";
	}
	
	
	@RequestMapping(value = "/MensajesOML", method = RequestMethod.GET)
	public String mensajesOML(Model model) {
		return "MensajesOML";
	}
}
