package org.backoffice.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.backoffice.dao.CodigoRepository;
import org.backoffice.dao.SistemaRepository;
import org.backoffice.model.BusquedaGeneralDTO;
import org.backoffice.model.Codigo;
import org.backoffice.model.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	SistemaRepository sistemaRepository;

	@Autowired
	CodigoRepository codigoRepository;
	
	@RequestMapping("/parque")
	public List<BusquedaGeneralDTO> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		List<BusquedaGeneralDTO> resultados = new ArrayList<BusquedaGeneralDTO>();
		
		List<Sistema> sistemas = sistemaRepository.findByIdSistema(name);
		for (Iterator iterator = sistemas.iterator(); iterator.hasNext();) {
			Sistema sistema = (Sistema) iterator.next();
			
			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("SISTEMA");
			resultado.setCodigo(sistema.getIdSistema());
			resultado.setDescripcion(sistema.getDescripcion());
			
			resultados.add(resultado);
		}
		
		List<Codigo> codigos = codigoRepository.findByCodigo(name);
		for (Iterator iterator = codigos.iterator(); iterator.hasNext();) {
			Codigo codigo = (Codigo) iterator.next();
			
			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("CODIGO");
			resultado.setCodigo(codigo.getCodigo());
			resultado.setDescripcion(codigo.getDescripcion());
			
			resultados.add(resultado);
		}
		
		List<Codigo> codigoD = codigoRepository.findByDescripcion(name);
		for (Iterator iterator = codigos.iterator(); iterator.hasNext();) {
			Codigo codigo = (Codigo) iterator.next();
			
			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("CODIGO");
			resultado.setCodigo(codigo.getCodigo());
			resultado.setDescripcion(codigo.getDescripcion());
			
			resultados.add(resultado);
		}

		return resultados; 
	}
}
