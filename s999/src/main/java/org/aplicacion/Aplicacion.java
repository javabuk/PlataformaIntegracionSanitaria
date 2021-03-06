package org.aplicacion;

import org.model.ConfigMensaje;
import org.repositorios.ConfigMensajeRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.repositorios")
@EnableMongoRepositories("org.repositorios")
@EntityScan("org.model")
@ComponentScan( basePackages = {"org.aplicacion", "org.controller", "org.servicios", "org.repositorios", "org.configuracion", "org.mongo.model"})
public class Aplicacion {

	private static final Logger log = LoggerFactory.getLogger(Aplicacion.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class);
	}
	  
}
