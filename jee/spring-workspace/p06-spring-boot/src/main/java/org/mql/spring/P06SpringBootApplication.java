package org.mql.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class P06SpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(P06SpringBootApplication.class, args);
	}

}
