package org.backoffice.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.backoffice.model.Sistema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// @RequestMapping(method = RequestMethod.POST, value = "/parque")
	@RequestMapping("/parque")
	public List<Sistema> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		List<Sistema> resultados = new ArrayList<Sistema>();
		resultados.add(new Sistema("1234", "SISTEMA 1"));
		resultados.add(new Sistema("1235", "SISTEMA 2"));
		resultados.add(new Sistema("1236", "SISTEMA 3"));
		return resultados;
	}
}
