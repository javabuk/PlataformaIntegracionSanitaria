package org.aplicacion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;



@Configuration
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoConfiguration {


	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("nasjavabuk:32769");
		//return new Mongo("nasjavabuk:32769");
	}

  @Override
  protected String getDatabaseName() {
    return "jorquiz";
  }
}
