package org.backoffice.controller;

import org.backoffice.dao.ConfiguracionRepository;
import org.backoffice.model.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
    ConfiguracionRepository configuracionRepository;
	
	@RequestMapping("/login")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        
        Configuracion nuevaConfiguracion = new Configuracion(new Long(500), "LOGIN", name);
        configuracionRepository.save(nuevaConfiguracion);
        
        for (Configuracion configuracion : configuracionRepository.findAll()) {
            System.out.println(configuracion);
        }
        
        return "login";
    }
	
}
