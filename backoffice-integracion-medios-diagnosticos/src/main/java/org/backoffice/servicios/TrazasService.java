package org.backoffice.servicios;

import java.sql.Timestamp;
import java.util.List;

import org.backoffice.model.Traza;

public interface TrazasService {

	List<Traza> buscarTrazasPorSistemaYFechas (String sistema, Timestamp fechaDesde, Timestamp fechaHasta);
	
}
