package org.backoffice.servicios;

public interface GestorPeticionesWSService {
	
	public String busquedaPeticiones(String mensajeConsulta);
	
	public String tratamientoPeticionesER7 (String mensajeHL7);

}
