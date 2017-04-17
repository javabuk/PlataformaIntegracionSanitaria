package org.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity ( name = "PSI_CORRELACIONES")
public class Correlacion {

	@Id
	@Column ( name = "CODIGOA")
	private String codigoA;
	
	@Column ( name = "SISTEMAA")
	private String sistemaA;
	
	@Column ( name = "TIPOA")
	private String tipoA;
	
	@Column ( name = "CODIGOB")
	private String codigoB;
	
	@Column ( name = "SISTEMAB")
	private String sistemaB;
	
	@Column ( name = "TIPOB")
	private String tipoB;
}
