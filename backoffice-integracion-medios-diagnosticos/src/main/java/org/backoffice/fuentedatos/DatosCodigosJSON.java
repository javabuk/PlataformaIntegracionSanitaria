package org.backoffice.fuentedatos;

public class DatosCodigosJSON {

	public Long a;
	public String y;

	public DatosCodigosJSON() {
		super();
	}

	public Long getA() {
		return a;
	}

	public void setA(Long a) {
		this.a = a;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "DatosCodigosJSON [a=" + a + ", y=" + y + "]";
	}

}
