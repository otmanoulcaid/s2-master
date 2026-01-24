package org.mql.spring;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.config.ApplicationConfig;
import org.mql.spring.models.Author;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EntryPoint {
	private ApplicationContext context;
	
	
	public EntryPoint() {
		loadContext();
		exp02();
	}
	
	private void loadContext() {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
	
	void exp01() {
		Author a1 = context.getBean("a01", Author.class);
		System.out.println("a1 = " + a1);
		Author a2 = context.getBean("a01", Author.class);
		System.out.println("a2 = " + a2);
	}
	
	void exp02() {
		System.out.println(context.getBean(String.class));
		BiblioService service = context.getBean(BiblioService.class);
		List<Author> authors = service.getAllAuthors();
		System.out.println(authors);
	}
	
	public static void main(String[] args) {
		new EntryPoint();
	}
	

}
