package org.mql.spring.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:biblio.properties"})
public class ApplicationProperties {
	//Aplication.properties
	
	@Value("${spring.application.name}") //Spel spring expression language
	private String applicationName;
	@Value("${server.port}")
	private String port;
	@Value("${server.servlet.context-path}")
	private String context;

	//propriete personalisé (par example dans biblio.properties)
	
	@Value("${mql.data.name}")
	private String sourceName;
	
	//propriete system (env vars)
	@Value("${user.name}")
	private String userName;

	@Value("${user.dir}")
	private String userDir;
	
	@Value("${java.home}")
	private String javaHome;
	
	@Value("${java.runtime.name}")
	private String jre;

	@Value("${java.vendor}")
	private String vendor;
	
	@Value("${java.vendor.url}")
	private String url;
	
	@Value("${java.version}")
	private String version;
	
	@Value("${java.version.date}")
	private String date;
	
	public String getUserDir() {
		return userDir;
	}
	
	public String getVersion() {
		return version;
	}

	public String getDate() {
		return date;
	}

	public String getUserName() {
		return userName;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public String getJre() {
		return jre;
	}

	public String getVendor() {
		return vendor;
	}

	public String getUrl() {
		return url;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public String getPort() {
		return port;
	}

	public String getContext() {
		return context;
	}
	
//	les vars env sont injectable dans .properties
}
