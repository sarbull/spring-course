package com.thalesgroup.trivia;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.thalesgroup.trivia.dao.QuestionCollectionDAO;

@Configuration
@ComponentScan
@ImportResource("classpath:services-config.xml")
public class ComponentConfig {

	@Bean
	public QuestionCollectionDAO collection() {
		// return new PersonCollectionDAO(new ArrayList<>(), 100);
		return new QuestionCollectionDAO(new HashSet<>(), 10001);
	}

	// @Bean
	// public PersonService service() throws FileNotFoundException {
	// return new PersonService(collection(), System.out);
	// // return new PersonService(collection(), new PrintStream(new BufferedOutputStream(new FileOutputStream("c:/tmp/spring.log")), true));
	// }

}
