package com.project.DeliveryAgentFrontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.DeliveryAgentFrontend.service.UserService;


@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
		     
	}
	
	
	@Bean
	public PasswordEncoder getPassEncoded() { 
		//return new BCryptPasswordEncoder(); 
		return NoOpPasswordEncoder.getInstance();
	}
	

	
//	public void configure(HttpSecurity http) throws Exception{		  
//		http.httpBasic().and().authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
//				.antMatchers("/user").hasRole("USER")
//				.antMatchers("/").permitAll()
//				.and()
//				.formLogin();
//	}
	@Override
	public void configure(HttpSecurity http) throws Exception{	
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/**").hasRole("USER")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .loginPage("/login") 
	        .and()
            .logout()
            	.logoutSuccessUrl("/")
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}

	
}
