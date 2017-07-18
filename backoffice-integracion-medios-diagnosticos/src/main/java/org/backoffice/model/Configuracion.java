package org.backoffice.model;

//@Entity ( name = "CONFIGURACION_HIS")
public class Configuracion {

	// @Id
	// @Column ( name = "ID")
	private Long id;

	// @Column ( name = "CLAVE")
	private String clave;

	// @Column ( name = "VALOR")
	private String valor;

	public Configuracion() {
	}

	public Configuracion(Long id, String clave, String valor) {
		super();
		this.id = id;
		this.clave = clave;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", clave=" + clave + ", valor=" + valor + "]";
	}

}
