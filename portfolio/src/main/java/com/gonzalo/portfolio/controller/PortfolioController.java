package com.gonzalo.portfolio.controller;

import com.gonzalo.portfolio.model.Proyecto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PortfolioController {


    @GetMapping("/portfolio")
    public String portfolio( @RequestParam(name = "categoria", defaultValue = "todas") String categoria,
                             @RequestParam(name = "anio", defaultValue = "") String anio,
                             Model model) {
        List<Proyecto> proyectos = crearProyectos();

        Integer anioNumero = null;   // null = "no filtrar por año"
        String errorAnio = null;

        if (!anio.isBlank()) {
            try {
                anioNumero = Integer.parseInt(anio.trim());
            } catch (NumberFormatException e) {
                errorAnio = "Introduce un año válido";
                // anioNumero sigue en null
            }
        }

        model.addAttribute("proyectos", filtrarProyectos(proyectos, categoria, anioNumero));
        model.addAttribute("categoria", categoria);
        model.addAttribute("anio", anio);
        model.addAttribute("errorAnio", errorAnio);

        return "portfolio";
    }

    private List<Proyecto> crearProyectos() {
        List<Proyecto> lista = new ArrayList<>();
            lista.add(new Proyecto("Springbootp7", 2026, "programacion", "Proyecto pequeño de springboot, varios idiomas.", "completado", List.of("Java", "Springboot"),"https://github.com/Trole981/EntornoServidor/tree/master/p7springboot", null));
            lista.add(new Proyecto("PatronFactory", 2024, "diseño", "Proyecto pequeño de patrones de diseño.", "completado", List.of("Java", "Patrones de diseño"),null, "/img/Factory.png"));
            lista.add(new Proyecto("Singleton", 2020, "estructura", "Proyecto pequeño de patrones de diseños.", "completado", new ArrayList<>(),"https://github.com/Trole981/EntornoServidor/tree/master/Singleton", "/img/Singleton.png"));
        return lista;
    }

    private List<Proyecto> filtrarProyectos(List<Proyecto> proyectos, String categoria, Integer anio){
        List<Proyecto> resultado=new ArrayList<>();
        for(Proyecto p: proyectos){
            if(categoria==null || categoria.equals("todas")){
                if(anio==null){resultado.add(p);}
                else{
                    if(p.getAnio()==anio){resultado.add(p);}
                }
            }
            else{
                if(anio==null){
                    if(p.getCategoria().equals(categoria)){resultado.add(p);}
                }
                else{
                    if(p.getCategoria().equals(categoria) && p.getAnio()==anio){resultado.add(p);}
                }
            }
        }
        return resultado;
    }
}
