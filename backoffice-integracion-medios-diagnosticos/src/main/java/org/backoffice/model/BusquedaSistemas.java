package org.backoffice.model;

public class BusquedaSistemas {

	private String idSistemaBusq;

	private String descripcionBusq;

	public BusquedaSistemas() {

	}

	public BusquedaSistemas(String idSistemaBusq, String descripcionBusq) {
		super();
		this.idSistemaBusq = idSistemaBusq;
		this.descripcionBusq = descripcionBusq;
	}

	public String getIdSistemaBusq() {
		return idSistemaBusq;
	}

	public void setIdSistemaBusq(String idSistemaBusq) {
		this.idSistemaBusq = idSistemaBusq;
	}

	public String getDescripcionBusq() {
		return descripcionBusq;
	}

	public void setDescripcionBusq(String descripcionBusq) {
		this.descripcionBusq = descripcionBusq;
	}

	@Override
	public String toString() {
		return "Sistema [idSistema=" + idSistemaBusq + ", descripcion=" + descripcionBusq + "]";
	}
}
