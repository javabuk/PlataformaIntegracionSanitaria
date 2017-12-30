package org.backoffice.model;

public class DatosSituacionActual {
	
	private int totalCodigosRadiologia;
	
	private int totalCodiosLaboratorio;
	

	public DatosSituacionActual() {
	}
	
	public DatosSituacionActual(int totalCodigosRadiologia, int totalCodiosLaboratorio) {
		super();
		this.totalCodigosRadiologia = totalCodigosRadiologia;
		this.totalCodiosLaboratorio = totalCodiosLaboratorio;
	}



	public int getTotalCodigosRadiologia() {
		return totalCodigosRadiologia;
	}

	public void setTotalCodigosRadiologia(int totalCodigosRadiologia) {
		this.totalCodigosRadiologia = totalCodigosRadiologia;
	}

	public int getTotalCodiosLaboratorio() {
		return totalCodiosLaboratorio;
	}

	public void setTotalCodiosLaboratorio(int totalCodiosLaboratorio) {
		this.totalCodiosLaboratorio = totalCodiosLaboratorio;
	}

}
