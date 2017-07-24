package org.backoffice.fuentedatos;

public class DatosCodigosDTO {
	
	public Long total;
	public String descripcion;
	
	public DatosCodigosDTO() {
		super();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "DatosCodigosDTO [total=" + total + ", descripcion="
				+ descripcion + "]";
	}
	

}
