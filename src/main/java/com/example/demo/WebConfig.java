package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	@Bean
	    public FilterRegistrationBean CorsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.addAllowedOrigin("http://localhost:4200"); // Autoriser toutes les origines
	        config.addAllowedMethod("*");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("DELETE");// Autoriser toutes les méthodes HTTP (GET, POST, PUT, DELETE, etc.)
	        config.addAllowedHeader("*");
	        config.addAllowedHeader("Content-Type");
	        config.addAllowedHeader("Authorization");; // Autoriser tous les en-têtes
	        config.setAllowCredentials(true); // Autoriser les credentials (cookies, authentification HTTP, etc.)

	      
	        source.registerCorsConfiguration("/**", config); // Appliquer la configuration CORS à toutes les URL

	        CorsFilter corsFilter = new CorsFilter(source);
	        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(corsFilter);
	        registrationBean.setOrder(0); // Assurez-vous que ce filtre est exécuté en premier
	        

	        return registrationBean;
	    }
}