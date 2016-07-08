package org.springboot.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
