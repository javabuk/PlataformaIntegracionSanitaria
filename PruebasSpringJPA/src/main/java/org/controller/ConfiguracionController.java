package org.controller;

import org.servicios.ConfiguracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfiguracionController {

	private ConfiguracionService configuracionService;

    @Autowired
    public void setCService(ConfiguracionService configuracionService) {
        this.configuracionService = configuracionService;
    }
    
    @RequestMapping(value = "/configuraciones", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("configuraciones", configuracionService.findByMensajeOrigen("OMG^O19"));
        return "configuraciones";
    }
}
