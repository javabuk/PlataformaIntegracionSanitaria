package org.backoffice.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.backoffice.dao.CodigoRepository;
import org.backoffice.dao.CorrelacionRepository;
import org.backoffice.dao.SistemaRepository;
import org.backoffice.model.BusquedaGeneralDTO;
import org.backoffice.model.Codigo;
import org.backoffice.model.Correlacion;
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

	@Autowired
	CorrelacionRepository correlacionRepository;

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
			resultado.setTipoCodigo(codigo.getTipo());
			resultado.setSistema(codigo.getIdSistema());
			resultados.add(resultado);
		}

		// Buscamos duplicados solo en los resultados de tipo codigo
		List<BusquedaGeneralDTO> resultadosFiltrados = resultados.stream().filter(c -> c.getTipo().equals("CODIGO"))
				.collect(Collectors.toList());

		List<Codigo> codigoD = codigoRepository.findCodigosPorDescripcion(name);
		for (Iterator iterator = codigoD.iterator(); iterator.hasNext();) {
			Codigo codigo = (Codigo) iterator.next();

			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("CODIGO");
			resultado.setCodigo(codigo.getCodigo());
			resultado.setDescripcion(codigo.getDescripcion());
			resultado.setTipoCodigo(codigo.getTipo());
			resultado.setSistema(codigo.getIdSistema());

			boolean idExists = resultadosFiltrados.stream().anyMatch(t -> (t.getCodigo().equals(codigo.getCodigo())
					&& t.getSistema().equals(codigo.getIdSistema()) && t.getTipoCodigo().equals(codigo.getTipo())));
			if (!idExists) {
				resultados.add(resultado);
			}
		}

		List<Correlacion> correlacionesA = correlacionRepository.findByCodigoA(name);
		for (Iterator iterator = correlacionesA.iterator(); iterator.hasNext();) {
			Correlacion correlacion = (Correlacion) iterator.next();
			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("CORRELACION");
			resultado.setCodigo(correlacion.getCodigoA());
			resultado.setTipoCodigo(correlacion.getTipoA());
			resultado.setSistema(correlacion.getSistemaA());
			resultado.setCodigoB(correlacion.getCodigoB());
			resultado.setTipoCodigoB(correlacion.getTipoB());
			resultado.setSistemaB(correlacion.getSistemaB());

			resultados.add(resultado);
		}

		List<Correlacion> correlacionesB = correlacionRepository.findByCodigoB(name);
		for (Iterator iterator = correlacionesB.iterator(); iterator.hasNext();) {
			Correlacion correlacion = (Correlacion) iterator.next();
			BusquedaGeneralDTO resultado = new BusquedaGeneralDTO();
			resultado.setTipo("CORRELACION");
			resultado.setCodigo(correlacion.getCodigoA());
			resultado.setTipoCodigo(correlacion.getTipoA());
			resultado.setSistema(correlacion.getSistemaA());
			resultado.setCodigoB(correlacion.getCodigoB());
			resultado.setTipoCodigoB(correlacion.getTipoB());
			resultado.setSistemaB(correlacion.getSistemaB());

			resultados.add(resultado);
		}

		return resultados;
	}
}
