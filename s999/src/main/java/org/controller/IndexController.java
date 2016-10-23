package org.controller;

import org.model.DatosLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class IndexController {
 
    @RequestMapping("/")
    String index(){
        return "Login";
    }
    
    @RequestMapping(value = "/VistaGeneral" , method = RequestMethod.POST)
    String vistaGeneral(Model model, DatosLogin datosLogin){
    	if(datosLogin.getUsuario().equalsIgnoreCase("jorge")){
    		model.addAttribute("datosLogin", datosLogin);
    		return "VistaGeneral3";
    	}else{
    		return "ErrorLogin";
    	}
    }
    
}
