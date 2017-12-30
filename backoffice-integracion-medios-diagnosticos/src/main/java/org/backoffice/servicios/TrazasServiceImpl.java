package org.backoffice.servicios;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.backoffice.dao.SistemaRepository;
import org.backoffice.dao.TrazaRepository;
import org.backoffice.model.Traza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrazasServiceImpl implements TrazasService {

	@Autowired
	TrazaRepository trazaRepository;

	@Autowired
	SistemaRepository sistemaRepository;
	
	@Override
	public List<Traza> buscarTrazasPorSistemaYFechas(String sistema,
			Timestamp fechaDesde, Timestamp fechaHasta) {
		
		if(sistema != null && (fechaDesde==null || fechaHasta==null)){
			return trazaRepository.findTrazasPorSistema(sistema);
		}else if (sistema == null){
			if(fechaDesde != null && fechaHasta != null){
				return trazaRepository.findTrazasEntreFechas(fechaDesde, fechaHasta);
			}else{
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -100);
				try {
					Date yesterday = dateFormat.parse(dateFormat.format(cal.getTime()));

					fechaDesde = new Timestamp(yesterday.getTime());
					fechaHasta = new Timestamp(System.currentTimeMillis());

				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				} 
				return trazaRepository.findTrazasEntreFechas(fechaDesde, fechaHasta);
			}
		}
		return null;
				
	}

}
