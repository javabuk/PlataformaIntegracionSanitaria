package org.backoffice.servicios;

import java.util.List;

import org.backoffice.fuentedatos.CodigoDTO;
import org.backoffice.fuentedatos.CorrelacionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CorrelacionesServiceImpl implements CorrelacionesService {

	/* Recuperamos informacion del fichero de propiedades */
	@Value("${prop.sql.insertCodigos}")
	private String insertCodigosSQL;

	@Value("${prop.sql.insertCorrelaciones}")
	private String insertCorrelacionesSQL;

	@Override
	public String generarSentenciasSQLCodigos(List<CodigoDTO> codigos) {
		String sentenciaSQL = "";
		StringBuilder sentencia = new StringBuilder();

		if (codigos != null) {

			for (int x = 0; x < codigos.size(); x++) {
				sentenciaSQL = String.format(insertCodigosSQL, codigos.get(x).getCodigo(),
						codigos.get(x).getDescripcion(), codigos.get(x).getSistema(), codigos.get(x).getTipo());

				sentencia.append(sentenciaSQL);
			}
		}
		return sentencia.toString();
	}

	@Override
	public String generarSentenciasSQLCorrelaciones(List<CorrelacionDTO> correlaciones) {
		String sentenciaSQL = "";
		StringBuilder sentencia = new StringBuilder();

		if (correlaciones != null) {

			for (int x = 0; x < correlaciones.size(); x++) {
				sentenciaSQL = String.format(insertCorrelacionesSQL, correlaciones.get(x).getCodigoA(),
						correlaciones.get(x).getSistemaA(), correlaciones.get(x).getTipoA(),
						correlaciones.get(x).getCodigoB(), correlaciones.get(x).getSistemaB(),
						correlaciones.get(x).getTipoB());

				sentencia.append(sentenciaSQL);
			}
		}
		return sentencia.toString();
	}

}
