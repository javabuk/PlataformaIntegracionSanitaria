package org.model;
/**
 * Clase que se utiliza para recoger los datos del formulario de la pregunta y utilizarlos despues
 * @author Jorge
 *
 */
public class DatosPregunta {

	public String texto;
	
	public String explicacion;
	
	public int tipo;
	
	public int categoria;
	
	public String respuestaCorrecta;
	
	public String respuestaErronea1;
	
	public String respuestaErronea2;
	
	public String respuestaErronea3;
	
	public String respuestaErronea4;
	
	public String respuestaErronea5;
	
	public String respuestaErronea6;

	public DatosPregunta() {
		super();
	}

	public DatosPregunta(String texto, String explicacion, int tipo, int categoria, String respuestaCorrecta,
			String respuestaErronea1, String respuestaErronea2, String respuestaErronea3, String respuestaErronea4,
			String respuestaErronea5, String respuestaErronea6) {
		super();
		this.texto = texto;
		this.explicacion = explicacion;
		this.tipo = tipo;
		this.categoria = categoria;
		this.respuestaCorrecta = respuestaCorrecta;
		this.respuestaErronea1 = respuestaErronea1;
		this.respuestaErronea2 = respuestaErronea2;
		this.respuestaErronea3 = respuestaErronea3;
		this.respuestaErronea4 = respuestaErronea4;
		this.respuestaErronea5 = respuestaErronea5;
		this.respuestaErronea6 = respuestaErronea6;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getRespuestaErronea1() {
		return respuestaErronea1;
	}

	public void setRespuestaErronea1(String respuestaErronea1) {
		this.respuestaErronea1 = respuestaErronea1;
	}

	public String getRespuestaErronea2() {
		return respuestaErronea2;
	}

	public void setRespuestaErronea2(String respuestaErronea2) {
		this.respuestaErronea2 = respuestaErronea2;
	}

	public String getRespuestaErronea3() {
		return respuestaErronea3;
	}

	public void setRespuestaErronea3(String respuestaErronea3) {
		this.respuestaErronea3 = respuestaErronea3;
	}

	public String getRespuestaErronea4() {
		return respuestaErronea4;
	}

	public void setRespuestaErronea4(String respuestaErronea4) {
		this.respuestaErronea4 = respuestaErronea4;
	}

	public String getRespuestaErronea5() {
		return respuestaErronea5;
	}

	public void setRespuestaErronea5(String respuestaErronea5) {
		this.respuestaErronea5 = respuestaErronea5;
	}

	public String getRespuestaErronea6() {
		return respuestaErronea6;
	}

	public void setRespuestaErronea6(String respuestaErronea6) {
		this.respuestaErronea6 = respuestaErronea6;
	}
	
	
	
}
