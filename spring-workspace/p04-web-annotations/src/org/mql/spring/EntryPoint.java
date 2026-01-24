package org.mql.spring;

//import javax.servlet.annotation.HandlesTypes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.mql.spring.config.ApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EntryPoint implements WebApplicationInitializer
{
	public EntryPoint() {
		org.springframework.web.SpringServletContainerInitializer servlet; 
		System.out.println(">>> new EntryPoint()");
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println(">>> onStartUp()");

		DispatcherServlet servlet = new DispatcherServlet();

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfig.class);

		servlet.setApplicationContext(context);

		Dynamic controller = servletContext.addServlet("controller", servlet);
		controller.addMapping("/biblio/*");
		controller.setLoadOnStartup(1);
	}
}
