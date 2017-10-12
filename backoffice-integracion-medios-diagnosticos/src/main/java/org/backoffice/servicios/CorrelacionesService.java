package org.backoffice.servicios;

import java.util.List;

import org.backoffice.fuentedatos.CodigoDTO;
import org.backoffice.fuentedatos.CorrelacionDTO;

public interface CorrelacionesService {

	public String generarSentenciasSQLCodigos(List<CodigoDTO> codigos);

	public String generarSentenciasSQLCorrelaciones(List<CorrelacionDTO> codigos);
}
