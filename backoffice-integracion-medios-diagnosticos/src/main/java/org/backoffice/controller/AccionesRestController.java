package org.backoffice.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.backoffice.fuentedatos.CodigoDTO;
import org.backoffice.fuentedatos.CorrelacionDTO;
import org.backoffice.util.SQLUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccionesRestController {
	@PostMapping("/recuperarSQL")
	public String recuperarSQL(HttpServletRequest request, Model model) {
		List<CorrelacionDTO> correlaciones = (List<CorrelacionDTO>) request.getSession().getAttribute("correl");
		List<CodigoDTO> codigos = (List<CodigoDTO>) request.getSession().getAttribute("sesionCodigosA");

		Enumeration<String> nombreParametros = request.getParameterNames();
		while (nombreParametros.hasMoreElements()) {
			System.out.println(nombreParametros.nextElement());
		}
		String sistema = request.getParameter("sistema");
		String tipo = request.getParameter("tipo");

		return SQLUtils.createInsertsCodigo(codigos, sistema, tipo);
	}

	@PostMapping("/recuperarSQLB")
	public String recuperarSQLB(HttpServletRequest request, Model model) {
		List<CodigoDTO> codigos = (List<CodigoDTO>) request.getSession().getAttribute("sesionCodigosB");

		Enumeration<String> nombreParametros = request.getParameterNames();
		while (nombreParametros.hasMoreElements()) {
			System.out.println(nombreParametros.nextElement());
		}
		String sistema = request.getParameter("sistema");
		String tipo = request.getParameter("tipo");

		return SQLUtils.createInsertsCodigo(codigos, sistema, tipo);
	}

	@PostMapping("/recuperarSQLCorrelacion")
	public String recuperarSQLCorrelacion(HttpServletRequest request, Model model) {
		List<CorrelacionDTO> correlaciones = (List<CorrelacionDTO>) request.getSession().getAttribute("correl");

		String sistemaA = request.getParameter("sistemaA");
		String sistemaB = request.getParameter("sistemaB");
		String tipo = request.getParameter("tipo");

		return SQLUtils.createInsertsCorrelaciones(correlaciones, sistemaA, sistemaB, tipo);
	}
}
