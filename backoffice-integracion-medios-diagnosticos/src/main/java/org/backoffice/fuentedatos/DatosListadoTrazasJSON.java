package org.backoffice.fuentedatos;

public class DatosListadoTrazasJSON {
	
	public Long total;
	public String leyenda;
	
	public DatosListadoTrazasJSON() {
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

	@Override
	public String toString() {
		return "DatosListadoTrazasJSON [total=" + total + ", leyenda="
				+ leyenda + "]";
	}
	
}
