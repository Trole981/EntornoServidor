package com.example.p2springboot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanController {

    @GetMapping("/")
    public String plan(@RequestParam(defaultValue = "estudiante") String nombre, Model model) {

        // Misma posición en ambas listas = misma asignatura
        List<String> asignaturas = List.of("Programación", "Bases de datos", "Lenguajes de marcas");
        List<Integer> duraciones = List.of(25, 40, 30);

        int totalMinutos = duraciones.stream().mapToInt(Integer::intValue).sum();
        double totalHoras = totalMinutos / 60.0;

        model.addAttribute("nombre", nombre);
        model.addAttribute("titulo", "Mi plan de estudio de hoy");
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("duraciones", duraciones);
        model.addAttribute("totalMinutos", totalMinutos);
        model.addAttribute("totalHoras", totalHoras);

        return "plan";
    }
}
