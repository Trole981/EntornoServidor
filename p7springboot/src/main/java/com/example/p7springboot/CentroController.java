package com.example.p7springboot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Rutas de la web del centro cultural: inicio (/) y preparación de la visita (/visita).
 *
 * El controlador no traduce nada ni decide el idioma. Solo entrega códigos de actividad;
 * los textos (título, descripción, fecha, duración y lugar) se buscan en los archivos
 * messages*.properties con claves del tipo actividad.<codigo>.titulo.
 */
@Controller
public class CentroController {

	/**
	 * Actividades fijas en memoria (sin base de datos). Cada código identifica el grupo
	 * de claves de mensaje que describe esa actividad en español e inglés.
	 */
	private static final List<String> ACTIVIDADES = List.of("ceramica", "guitarra", "cine", "fotografia");

	/**
	 * Página de inicio: selección de actividades.
	 *
	 * @param model datos que necesita la plantilla
	 * @return nombre lógico de la plantilla "inicio"
	 */
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("actividades", ACTIVIDADES);
		return "inicio";
	}

	/**
	 * Página con información práctica para organizar la visita. Su contenido es propio
	 * y no depende de datos del modelo.
	 *
	 * @return nombre lógico de la plantilla "visita"
	 */
	@GetMapping("/visita")
	public String visita() {
		return "visita";
	}
}
