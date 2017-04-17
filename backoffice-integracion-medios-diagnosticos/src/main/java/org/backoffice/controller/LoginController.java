package org.backoffice.controller;

import java.util.Random;

import org.backoffice.dao.CodigoRepository;
import org.backoffice.dao.ConfiguracionRepository;
import org.backoffice.model.Codigo;
import org.backoffice.model.Configuracion;
import org.backoffice.model.DatosSituacionActual;
import org.backoffice.model.MensajeConfirmacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
    ConfiguracionRepository configuracionRepository;
	
	@Autowired
	CodigoRepository codigoRepository;
	
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
	
	
	@RequestMapping("/menuprincipal")
    public String menuPrincipal(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        
        /*
        Codigo nuevoCodigo = new Codigo();
        
        nuevoCodigo.setCodigo((new Integer ((new Random()).nextInt())).toString());
        //nuevoCodigo.setCodigo("1");
        nuevoCodigo.setDescripcion("Descripcion " + (new Random()).nextInt());
        //nuevoCodigo.setDescripcion("Descripcion 1");
        nuevoCodigo.setIdSistema("INFO33");
        nuevoCodigo.setTipo("LAB");
        
        codigoRepository.save(nuevoCodigo);
        */
        
        for (Codigo codigoAll : codigoRepository.findAll()) {
            System.out.println(codigoAll);
        }
        
        return "menuprincipal";
    }
	
	@RequestMapping("/tabla")
    public String tabla(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
        
        return "tabla";
    }
	
	@RequestMapping("/form")
    public String form(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
        
        return "form";
    }
	
	@RequestMapping("/upload")
    public String upload(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
        
        return "upload";
    }
	
	@RequestMapping("/codigos")
    public String codigos(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {		
		model.addAttribute("codigosExistentes", codigoRepository.findAll());        
        return "codigos";
    }
	
	@RequestMapping("/formulariocodigo")
    public String formulariocodigo(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, Codigo datosCodigo) {		
		model.addAttribute("datosCodigo", datosCodigo);
		return "formulariocodigo";
    }
	
	@RequestMapping(value = "/GrabarCodigo", method = RequestMethod.POST)
	public String grabarExamen(Model model, Codigo datosCodigo, MensajeConfirmacion mensajeConfirmacion) {

		try {
			codigoRepository.save(datosCodigo);
			mensajeConfirmacion.setMensaje("Insercion correcta");
		} catch (Exception e) {
			mensajeConfirmacion.setMensaje(e.getMessage());
			mensajeConfirmacion.setExcepcion(e);
			e.printStackTrace();
		}
		
		model.addAttribute("mensaje", mensajeConfirmacion);
		return "resultadoCodigo";
	}
	
	@RequestMapping("/situacionActual")
    public String situacionActual(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, DatosSituacionActual datos) {		
		//model.addAttribute("datos", datosCodigo);
		return "situacionActual";
    }
	
}
