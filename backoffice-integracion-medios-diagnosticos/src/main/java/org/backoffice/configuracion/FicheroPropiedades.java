package org.backoffice.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@Configuration
public class FicheroPropiedades {

	@Value("${spring.profiles.active}")
	private String entorno;

	@Bean
	public String entorno() {
		return entorno;
	}

}
