package org.mql.spring;

import org.mql.spring.models.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class P07SpringBootJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(P07SpringBootJpaRestApplication.class, args);
	}

	@Bean
	public Author a03() {
		return new Author(103, "Brendan Eich", 1961);
	}

	@Bean
	public Author a04() {
		return new Author(104,"Tim Berners-Lee",1955);		
	}

	@Bean
	public String title() {
		return "Gestion de bibliotheque";
	}

}
