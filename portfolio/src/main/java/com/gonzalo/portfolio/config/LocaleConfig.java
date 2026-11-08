package com.gonzalo.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {
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
        resolvedor.setDefaultLocale(Locale.forLanguageTag("es")); //El lenguaje por defecto es Español
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
