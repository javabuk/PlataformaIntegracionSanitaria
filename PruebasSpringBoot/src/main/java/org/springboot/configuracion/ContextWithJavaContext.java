package org.springboot.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.springboot.entidad")
public class ContextWithJavaContext {
	
	public ContextWithJavaContext(){
		super();
	}
}
