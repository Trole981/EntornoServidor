package com.example.p7springboot;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CentroCulturalTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void inicioMuestraActividadesEnEspanolPorDefecto() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Esta temporada en el Aljibe")))
				.andExpect(content().string(containsString("Taller de cerámica a mano")))
				.andExpect(content().string(containsString("Concierto de guitarra flamenca")))
				.andExpect(content().string(containsString("Ciclo de cine mudo")))
				.andExpect(content().string(containsString("Sábado 14 de noviembre, 11:00")))
				.andExpect(content().string(containsString("Sala Alhambra")));
	}

	@Test
	void inicioCambiaAInglesConLangEnIncluidosLosDatosPracticos() throws Exception {
		mockMvc.perform(get("/").param("lang", "en"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("This season at the Aljibe")))
				.andExpect(content().string(containsString("Hand-built pottery workshop")))
				.andExpect(content().string(containsString("Saturday 14 November, 11:00 am")))
				.andExpect(content().string(containsString("Duration")))
				.andExpect(content().string(not(containsString("Taller de cerámica"))));
	}

	@Test
	void visitaTieneContenidoPropioEnAmbosIdiomas() throws Exception {
		mockMvc.perform(get("/visita"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Organiza tu visita")))
				.andExpect(content().string(containsString("Horarios")))
				.andExpect(content().string(not(containsString("Taller de cerámica"))));
		mockMvc.perform(get("/visita").param("lang", "en"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Opening hours")))
				.andExpect(content().string(containsString("Getting here")));
	}

	@Test
	void ambasPaginasComparteCabeceraNavegacionYPie() throws Exception {
		for (String ruta : new String[] { "/", "/visita" }) {
			mockMvc.perform(get(ruta))
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("class=\"hero\"")))
					.andExpect(content().string(containsString("class=\"nav\"")))
					.andExpect(content().string(containsString("class=\"pie\"")))
					.andExpect(content().string(containsString("Calle del Aljibe, 12")));
		}
	}

	@Test
	void elSelectorDeIdiomaVuelveALaMismaPagina() throws Exception {
		mockMvc.perform(get("/visita"))
				.andExpect(content().string(containsString("href=\"/visita?lang=en\"")))
				.andExpect(content().string(containsString("href=\"/visita?lang=es\"")));
		mockMvc.perform(get("/"))
				.andExpect(content().string(containsString("href=\"/?lang=en\"")));
	}

	@Test
	void elIdiomaElegidoSeConservaDuranteLaSesionYEntrePaginas() throws Exception {
		MvcResult resultado = mockMvc.perform(get("/").param("lang", "en"))
				.andExpect(status().isOk())
				.andReturn();
		MockHttpSession sesion = (MockHttpSession) resultado.getRequest().getSession(false);

		mockMvc.perform(get("/visita").session(sesion))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Plan your visit")));
		mockMvc.perform(get("/").session(sesion).param("lang", "es"))
				.andExpect(content().string(containsString("Esta temporada en el Aljibe")));
	}

	@Test
	void loscatalogosTienenExactamenteLasMismasClavesYSinValoresVacios() throws Exception {
		Properties es = cargar("/messages.properties");
		Properties en = cargar("/messages_en.properties");
		assertEquals(es.stringPropertyNames(), en.stringPropertyNames());
		for (String clave : es.stringPropertyNames()) {
			assertFalse(es.getProperty(clave).isBlank(), "Vacío en español: " + clave);
			assertFalse(en.getProperty(clave).isBlank(), "Vacío en inglés: " + clave);
		}
	}

	private Properties cargar(String recurso) throws Exception {
		Properties propiedades = new Properties();
		try (InputStream in = getClass().getResourceAsStream(recurso);
				InputStreamReader lector = new InputStreamReader(in, StandardCharsets.UTF_8)) {
			propiedades.load(lector);
		}
		return propiedades;
	}
}
