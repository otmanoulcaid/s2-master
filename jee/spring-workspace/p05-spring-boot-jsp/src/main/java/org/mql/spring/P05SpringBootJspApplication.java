package org.mql.spring;

import org.mql.spring.models.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * 
 * un projet spring boot est un projet spring avec les principales caracteristiques suivantes:
 * + il s'agit d'un projet maven (ou gradle) d'ou gestion automatisé de dependances 
 * + une instance de serveur tomcat integrer ou (embarquer) qui demarre automatiquement avec l'application 
 * + un controleur MVC2 (MVC par abus de language) fournie, instancié et configuré automatiquement : DispatcherServlet
 * + un base-package preconfiguré, il s'agit du cette class
 * + un point d'entré qui est cette class généré automatiquement sous forme d'une class Main
 * + configuration par annotation et activé automatiquement
 * 
 */

@SpringBootApplication
public class P05SpringBootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(P05SpringBootJspApplication.class, args);
	}

	@Bean //( annotation de methode pour fournir un bean avec son nom)
	public Author a03() {
		return new Author(102, "Tim berners-Lee", 1961);
	}
}
