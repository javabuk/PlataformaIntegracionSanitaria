package org.backoffice.fuentedatos;

public class DatosListadoTrazasSistemaJSON {
	
	public Long total;
	public String leyenda;
	public String sistema;

	public DatosListadoTrazasSistemaJSON() {
		// TODO Auto-generated constructor stub
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	@Override
	public String toString() {
		return "DatosListadoTrazasSistemaJSON [total=" + total + ", leyenda="
				+ leyenda + ", sistema=" + sistema + "]";
	}
	

}
