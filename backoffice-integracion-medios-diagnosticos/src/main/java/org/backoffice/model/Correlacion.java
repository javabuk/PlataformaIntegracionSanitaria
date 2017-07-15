package org.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PSI_CORRELACIONES")
public class Correlacion {

	@Id
	@Column(name = "CODIGOA")
	private String codigoA;

	@Column(name = "SISTEMAA")
	private String sistemaA;

	@Column(name = "TIPOA")
	private String tipoA;

	@Column(name = "CODIGOB")
	private String codigoB;

	@Column(name = "SISTEMAB")
	private String sistemaB;

	@Column(name = "TIPOB")
	private String tipoB;

	public Correlacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Correlacion(String codigoA, String sistemaA, String tipoA, String codigoB, String sistemaB, String tipoB) {
		super();
		this.codigoA = codigoA;
		this.sistemaA = sistemaA;
		this.tipoA = tipoA;
		this.codigoB = codigoB;
		this.sistemaB = sistemaB;
		this.tipoB = tipoB;
	}

	public String getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(String codigoA) {
		this.codigoA = codigoA;
	}

	public String getSistemaA() {
		return sistemaA;
	}

	public void setSistemaA(String sistemaA) {
		this.sistemaA = sistemaA;
	}

	public String getTipoA() {
		return tipoA;
	}

	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}

	public String getCodigoB() {
		return codigoB;
	}

	public void setCodigoB(String codigoB) {
		this.codigoB = codigoB;
	}

	public String getSistemaB() {
		return sistemaB;
	}

	public void setSistemaB(String sistemaB) {
		this.sistemaB = sistemaB;
	}

	public String getTipoB() {
		return tipoB;
	}

	public void setTipoB(String tipoB) {
		this.tipoB = tipoB;
	}

}
