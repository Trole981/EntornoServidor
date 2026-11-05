package com.gonzalo.portfolio.controller;

import com.gonzalo.portfolio.model.Estudio;
import com.gonzalo.portfolio.model.Experiencia;
import com.gonzalo.portfolio.model.Habilidad;
import com.gonzalo.portfolio.model.Idioma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurriculumController {

    @GetMapping("/curriculum")
    public String curriculum(@RequestParam(name = "imprimir", defaultValue = "false") boolean imprimir, @Value("${cv.nombre}") String nombre, Model model){
        model.addAttribute("nombre", nombre);

        Habilidad[] habilidades = {
                new Habilidad("Java", "medio"),
                new Habilidad("HTML", "alto"),
                new Habilidad("SQL", "bajo"),
                new Habilidad("Git", "bajo")
        }; //Una variable local.
        model.addAttribute("habilidades", habilidades);

        Idioma[] idiomas = {
                new Idioma("Inglés", "medio"),
                new Idioma("Español", "alto")
        };
        model.addAttribute("idiomas", idiomas);

        String contacto = "gonza2007bagut@gmail.com";
        model.addAttribute("contacto", contacto);

        Estudio[] estudios = {
            new Estudio("Sistemas microinfirmaticos y redes", "CFGM", 2023, 2025),
            new Estudio("Desarrollo de aplcaciones Web", "CFGS", 2025, null)
        };
        model.addAttribute("estudios", estudios);

        Experiencia[] experiencias = {
                new Experiencia("Manager", "BPGames", "2 semanas"),
                new Experiencia("Manager", "Tzcat", "3 meses")
        };
        model.addAttribute("experiencias", experiencias);
        model.addAttribute("imprimir", imprimir);
        return "curriculum";
    }
}
