package com.project.DeliveryAgentFrontend;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryAgentFrontendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DeliveryAgentFrontendApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeliveryAgentFrontendApplication.class, args);
	}
	
	@Bean
	public ServletContextInitializer servletContextInitializer() {
	    return new ServletContextInitializer() {

	        @Override
	        public void onStartup(ServletContext servletContext) throws ServletException {
	            servletContext.getSessionCookieConfig().setName("DELIVERY_SESSION");
	        }
	    };

	}
}