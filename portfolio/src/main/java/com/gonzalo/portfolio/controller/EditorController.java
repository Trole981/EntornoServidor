package com.gonzalo.portfolio.controller;

import com.gonzalo.portfolio.form.CurriculumForm;
import com.gonzalo.portfolio.form.ProyectoForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class EditorController {

    @Value("${portfolio.max-proyectos}")
    private int maxProyectos;

    @GetMapping("/portfolio/editar")
    public String mostrarFormulario(Model model) {
        CurriculumForm form = new CurriculumForm();   // variable local

        model.addAttribute("form", form);
        model.addAttribute("max", maxProyectos);
        model.addAttribute("errores", new HashMap<String, String>());
        return "editar";   // nombre de tu plantilla
    }

    @PostMapping("/portfolio/editar")
    public String procesar(@ModelAttribute("form") CurriculumForm form,
                           @RequestParam(defaultValue = "") String accion,
                           Model model) {
        // 6.5 y 6.7 rellenarán el cuerpo
        if (accion.equals("anadir") && form.getProyectos().size() < maxProyectos) {
            form.getProyectos().add(new ProyectoForm());
        }

        model.addAttribute("max", maxProyectos);
        model.addAttribute("errores", new HashMap<String, String>());
        return "editar";
    }
}
