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

@SpringBootApplication
@EnableJpaRepositories("org.repositorios")
@EntityScan("org.model")
@ComponentScan( basePackages = {"org.aplicacion", "org.controller"})
public class Aplicacion {

	private static final Logger log = LoggerFactory.getLogger(Aplicacion.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class);
	}
	
	@Bean
	public CommandLineRunner demo(ConfigMensajeRepositorio repository) {
		return (args) -> {
			// save a couple of customers
			log.info("Insercion Inicial:");
			log.info("-------------------------------");
			ConfigMensaje configuracion = new ConfigMensaje();
			configuracion.setMensajeOrigen("OMG^O19");
			configuracion.setSistemaOrigen("INFO33");
			configuracion.setSistemaDestino("AXPE");
			configuracion.setTipoTrazabilidad(0);
			configuracion.setTraduccionMensaje("prueba");
			configuracion.setCorrelacionCodigos(0);
			
			
			repository.save(configuracion);
			log.info("-------------------------------");
			
			for( ConfigMensaje config : repository.findAll()){
				log.info("-----------" + config.getId() + "------------");
			}
			
			
			
			/*
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");*/
		};
	}
}
