package com.project.BuyerFrontend;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuyerFrontendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BuyerFrontendApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BuyerFrontendApplication.class, args);
	}
	
	@Bean
	public ServletContextInitializer servletContextInitializer() {
	    return new ServletContextInitializer() {

	        @Override
	        public void onStartup(ServletContext servletContext) throws ServletException {
	            servletContext.getSessionCookieConfig().setName("BUYER_SESSION");
	        }
	    };

	}
}