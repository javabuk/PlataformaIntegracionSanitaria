package org.backoffice.util;

import java.util.List;

import org.backoffice.fuentedatos.CodigoDTO;
import org.backoffice.fuentedatos.CorrelacionDTO;

public class SQLUtils {

	/**
	 * Genera las INSERT en la tabla de códigos a partir de una lista con los
	 * DTO de la tabla de codigos
	 * 
	 * @param codigos
	 * @return
	 */
	public static String createInsertsCodigo(List<CodigoDTO> codigos, String sistema, String tipo) {
		String resultado = "";
		if (codigos != null && codigos.size() > 0) {
			for (CodigoDTO codigoDTO : codigos) {
				resultado += String.format(
						"Insert into PSI_CODIGOS (CODIGO,DESCRIPCION,IDSISTEMA,TIPO) values ('%s','%s','%s',' %s');"
								+ System.lineSeparator(),
						codigoDTO.getCodigo(), codigoDTO.getDescripcion(), sistema, tipo);
			}

		}
		return resultado;
	}

	public static String createInsertsCorrelaciones(List<CorrelacionDTO> correlaciones, String sistemaA,
			String sistemaB, String tipo) {
		String resultado = "";
		if (correlaciones != null && correlaciones.size() > 0) {
			for (CorrelacionDTO correlacionDTO : correlaciones) {
				resultado += String.format(
						"Insert into PSI_CORRELACIONES (CODIGOA,SISTEMAA,TIPOA,CODIGOB,SISTEMAB,TIPOB) values ('%s','%s','%s',' %s');"
								+ System.lineSeparator(),
						correlacionDTO.getCodigoA(), sistemaA, tipo, correlacionDTO.getCodigoB(), sistemaB, tipo);
			}

		}
		return resultado;
	}

}
