package org.model;
/**
 * Clase para almacenar informacion que se utilice en confirmaciones de operaciones.
 * @author Jorge
 *
 */
public class MensajeConfirmacion {

	private String mensaje;
	private Object retorno;
	private Exception excepcion;
	
	public MensajeConfirmacion() {
		super();
	}

	public MensajeConfirmacion(String mensaje, Object retorno, Exception excepcion) {
		super();
		this.mensaje = mensaje;
		this.retorno = retorno;
		this.excepcion = excepcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}

	public Exception getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(Exception excepcion) {
		this.excepcion = excepcion;
	}
	
}
