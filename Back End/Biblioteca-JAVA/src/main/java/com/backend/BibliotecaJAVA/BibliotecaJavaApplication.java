package com.backend.BibliotecaJAVA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EntityScan("com.backend.model")
@EnableJpaRepositories("com.backend.repository")
@ComponentScan({"com.backend.service", "com.backend.controller"})
@SpringBootApplication
public class BibliotecaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaJavaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST","PUT", "DELETE"); // "/**" --> con esto indico que el front end de localhost:3000 pueda acceder a todos los metodos que tengo en controller
			}
		};
	}
}
