package org.mql.spring.config;

import org.mql.spring.models.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.mql.spring") // on l'ajout si on veut rajoutter un autre package a scanner
public class ApplicationConfig {
	public ApplicationConfig() {
	}
	
	@Bean //( annotation de methode pour fournir un bean avec son nom )
	public Author a03() {
		return new Author(101, "Rod Johnson", 1970);
	}
	
	@Bean //( annotation de methode pour fournir un bean avec son nom )
	public Author a04() {
		return new Author(102, "Erich Gamma", 1961);
	}
	
	@Bean
	public String Title() {
		return "Gestion de biblio";
	}
}
