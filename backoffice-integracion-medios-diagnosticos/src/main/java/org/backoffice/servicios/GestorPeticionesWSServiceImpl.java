package org.backoffice.servicios;

import java.rmi.RemoteException;

import org.backoffice.clientesWs.*;
import org.springframework.stereotype.Service;

import org.apache.commons.lang.*;

@Service
public class GestorPeticionesWSServiceImpl implements GestorPeticionesWSService {

	@Override
	public String busquedaPeticiones(String mensajeConsulta) {
		String resultado = "";
		IndicePeticionesProxy proxy = new IndicePeticionesProxy();
		try {
			
			//resultado  = proxy.consultarPeticionesER7(StringEscapeUtils.escapeHtml(mensajeConsulta));
			resultado  = proxy.consultarPeticionesER7(mensajeConsulta);
		} catch (RemoteException e) {
			resultado = e.toString();
			e.printStackTrace();
		}
		
		
		return resultado;
	}

	@Override
	public String tratamientoPeticionesER7(String mensajeHL7) {
		String resultado = "";
		IndicePeticionesProxy proxy = new IndicePeticionesProxy();
		try {
			resultado  = proxy.tratarPeticionER7(mensajeHL7);
		} catch (RemoteException e) {
			resultado = e.toString();
			e.printStackTrace();
		}
		
		
		return resultado;
	}

}
