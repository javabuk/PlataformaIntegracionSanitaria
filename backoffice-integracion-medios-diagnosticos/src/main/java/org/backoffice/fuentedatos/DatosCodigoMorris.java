package org.backoffice.fuentedatos;

public class DatosCodigoMorris {

	public String label;
	public Long value;

	public DatosCodigoMorris() {
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DatosCodigoMorris [label=" + label + ", value=" + value + "]";
	}

}
