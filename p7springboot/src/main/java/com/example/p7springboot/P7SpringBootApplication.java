package com.example.p7springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de P7: agenda de actividades de un centro cultural.
 */
@SpringBootApplication
public class P7SpringBootApplication {

	/**
	 * Arranca Spring Boot y el servidor web integrado.
	 *
	 * @param args argumentos opcionales de inicio
	 */
	public static void main(String[] args) {
		SpringApplication.run(P7SpringBootApplication.class, args);
	}
}
