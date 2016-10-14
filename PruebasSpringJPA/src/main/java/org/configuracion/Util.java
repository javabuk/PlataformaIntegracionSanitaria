package org.configuracion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {
	
	/***
	 * Metodo que devuelve la fecha actual en formato yyyymmddhhmmss
	 * @return
	 */
	public static String obtenerFechaActual() {
		Date fechaActual = new Date(System.currentTimeMillis());
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyymmddhhmmss");
		return dt1.format(fechaActual);
	}
	
	/***
	 * Metodo que devuelve una cadena de texto con un numero aleatorio entre 1 y 1.000.000
	 * @return
	 */
	public static String obtenerCorrelativo(){
		Random rand = new Random();
		return Integer.toString(rand.nextInt(1000000));
	}

}
