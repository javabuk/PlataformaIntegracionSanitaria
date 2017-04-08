package org.controller;

import org.model.MensajeHL7;
import org.servicios.ConfiguracionService;
import org.servicios.GeneracionHL7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HL7Controller {

	
	private GeneracionHL7Service hl7Service;

    @Autowired
    public void setCService(GeneracionHL7Service hl7Service) {
        this.hl7Service = hl7Service;
    }
	
	
	@RequestMapping(value = "/FormularioHL7", method = RequestMethod.GET)
	public String list(Model model) {
		return "FormularioHL7";
	}
	
	
	@RequestMapping(value = "/MensajesOML", method = RequestMethod.GET)
	public String mensajesOML(Model model) {
		model.addAttribute("mensajeHL7", new MensajeHL7());
		return "MensajesOML";
	}
	
	@RequestMapping(value = "/ResultadoMensajesHL7", method = RequestMethod.POST)
	public String ResultadoMensajesHL7(Model model, MensajeHL7 mensaje) {
		//mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje.getSistemaOrigen(), mensaje.getSistemaDestino(), mensaje.getMensaje()));
		mensaje.setMensaje(hl7Service.convertirMensajeOML(mensaje));
		model.addAttribute("mensaje", mensaje);
		return "ResultadoMensajesHL7";
	}
}
