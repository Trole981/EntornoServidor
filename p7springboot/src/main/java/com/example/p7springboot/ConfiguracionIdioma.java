package com.example.p7springboot;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Configura cómo se decide el idioma de cada petición y cómo puede cambiarse.
 *
 * Funcionamiento resumido:
 * 1. El SessionLocaleResolver recuerda el idioma en la sesión HTTP (no hay base de datos).
 * 2. El LocaleChangeInterceptor mira si la URL trae ?lang=es o ?lang=en y, si es así,
 *    actualiza el idioma guardado en la sesión.
 * 3. Thymeleaf usa ese idioma para resolver cada #{clave} en messages*.properties.
 */
@Configuration
public class ConfiguracionIdioma implements WebMvcConfigurer {

	/**
	 * Guarda el idioma elegido durante la sesión actual.
	 *
	 * Idioma inicial EXPLÍCITO: español. Se usa mientras la persona no haya elegido otro,
	 * sin depender del idioma del navegador ni del ordenador.
	 *
	 * @return resolvedor de idioma que utilizan Spring MVC y Thymeleaf
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolvedor = new SessionLocaleResolver();
		resolvedor.setDefaultLocale(Locale.forLanguageTag("es"));
		return resolvedor;
	} 

	/**
	 * Mecanismo EXPLÍCITO de cambio de idioma: el parámetro de consulta "lang".
	 *
	 * Ejemplos: /?lang=en, /visita?lang=es.
	 *
	 * @return interceptor que lee lang y actualiza el idioma de la sesión
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	/**
	 * Registra el interceptor para que se ejecute antes de cualquier controlador.
	 *
	 * @param registry registro de interceptores de Spring MVC
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
