package org.backoffice;


import org.backoffice.dao.ConfiguracionRepository;
import org.backoffice.model.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import static java.lang.System.exit;

//for jsr310 java 8 java.time.*
//@EntityScan(
//        basePackageClasses = { SpringBootConsoleApplication.class, Jsr310JpaConverters.class }
//)
@SpringBootApplication
public class Application{
//public class Application implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ConfiguracionRepository configuracionRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    /*
    //@Transactional(readOnly = true)
    @Transactional (propagation = Propagation.NEVER)
    @Override
    public void run(String... args) throws Exception {

        //System.out.println("DATASOURCE = " + dataSource);

        for (Configuracion configuracion : configuracionRepository.findAll()) {
            System.out.println(configuracion);
        }
        
        Configuracion nuevaConfiguracion = new Configuracion(new Long(400), "JORGE2", "VALOR2");
        configuracionRepository.save(nuevaConfiguracion);
        
        

        System.out.println("Done!");

        exit(0);
    }*/

}