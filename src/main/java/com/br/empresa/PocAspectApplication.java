package com.br.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocAspectApplication {

	/*
	 *@ A proposta dessa POC Spring AOP é tornar o projeto em sí em uma lib para usar
	 * como dependencia em outros projetos
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(PocAspectApplication.class, args);
	}

}
