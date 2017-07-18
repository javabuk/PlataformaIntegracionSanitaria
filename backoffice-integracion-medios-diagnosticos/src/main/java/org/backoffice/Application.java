package org.backoffice;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//for jsr310 java 8 java.time.*
//@EntityScan(
//        basePackageClasses = { SpringBootConsoleApplication.class, Jsr310JpaConverters.class }
//)
@SpringBootApplication
@EnableWebMvc
public class Application extends WebMvcAutoConfiguration {
	// public class Application implements CommandLineRunner {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// @Autowired
	// ConfiguracionRepository configuracionRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * //@Transactional(readOnly = true)
	 * 
	 * @Transactional (propagation = Propagation.NEVER)
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * //System.out.println("DATASOURCE = " + dataSource);
	 * 
	 * for (Configuracion configuracion : configuracionRepository.findAll()) {
	 * System.out.println(configuracion); }
	 * 
	 * Configuracion nuevaConfiguracion = new Configuracion(new Long(400),
	 * "JORGE2", "VALOR2"); configuracionRepository.save(nuevaConfiguracion);
	 * 
	 * 
	 * 
	 * System.out.println("Done!");
	 * 
	 * exit(0); }
	 */

}