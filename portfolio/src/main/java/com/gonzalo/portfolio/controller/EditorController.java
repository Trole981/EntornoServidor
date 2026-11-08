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
import java.util.List;
import java.util.Map;

@Controller
public class EditorController {  // Aqui va a aparecer todo lo que hace falta en la pantalla de editar el portfolio.

    private static final List<String> CATEGORIAS = List.of("aplicaciones", "sitios-web", "diseno");
    private static final List<String> ESTADOS = List.of("en-curso", "terminado");

    @Value("${portfolio.max-proyectos}")
    private int maxProyectos;

    @GetMapping("/portfolio/editar")
    public String mostrarFormulario(Model model) {
        CurriculumForm form = new CurriculumForm();   // variable local

        model.addAttribute("form", form);
        model.addAttribute("max", maxProyectos);
        model.addAttribute("errores", new HashMap<String, String>());//en los errores, creamos un HashMap para que se vayan agregando.
        return "editar";   // nombre de tu plantilla
    }

    @PostMapping("/portfolio/editar")
    public String procesar(@ModelAttribute("form") CurriculumForm form,
                           @RequestParam(defaultValue = "") String accion,
                           Model model) {

        if (form.getProyectos().size() > maxProyectos) {
            /*Comprobamos que haya menos proyectos que el maximo permitido. En caso contrario,
            da un error por sobrepasar el limite.*/
            Map<String, String> errores = new HashMap<>();
            errores.put("limite", "error.limite");
            model.addAttribute("max", maxProyectos);
            model.addAttribute("errores", errores);
            return "editar";
        }

        if (accion.equals("anadir") || accion.startsWith("quitar-")) {
            modificarFilas(form, accion, maxProyectos);
        }

        Map<String, String> errores = new HashMap<>();

        if (accion.equals("generar")) {
            validarDatos(form, errores, maxProyectos);//Comprobamos los datos.
            if (errores.isEmpty()) {
                //Si no hay errores, podemos mostrar la vista previa sin problemas.
                model.addAttribute("form", form);
                return "vista-previa";
            }
            // Si se quedó sin filas tras descartar las vacías, que haya una visible
            if (form.getProyectos().isEmpty()) {
                form.getProyectos().add(new ProyectoForm());
            }
        }

        model.addAttribute("max", maxProyectos);
        model.addAttribute("errores", errores);
        return "editar";
    }

    private void modificarFilas(CurriculumForm form, String accion, int max){
        if (accion.equals("anadir") && form.getProyectos().size() < maxProyectos) {
            form.getProyectos().add(new ProyectoForm());
        }
        else if (accion.startsWith("quitar-")) {
            try {
                int indice = Integer.parseInt(accion.substring("quitar-".length()));
                if (indice >= 0 && indice < form.getProyectos().size()) {
                    form.getProyectos().remove(indice);
                }
            } catch (NumberFormatException e) {
                // Valor manipulado: se ignora y no se quita nada
            }
        }
        if (form.getProyectos().isEmpty()) {
            form.getProyectos().add(new ProyectoForm());
        }
    }

    private boolean filaVacia(ProyectoForm p) {
        return p == null
                || (p.getTitulo().isBlank() && p.getAnio().isBlank()
                && p.getCategoria().isBlank() && p.getEstado().isBlank()
                && p.getDescripcion().isBlank());
    }

    private void validarDatos(CurriculumForm form, Map<String, String> errores, int max) {
        //  Límite: por si manipulan el HTML
        if (form.getProyectos().size() > max) {
            errores.put("limite", "error.limite");
            return; // no tiene sentido seguir validando
        }

        /* Descartar filas vacías y null ANTES de validar,
           para que los índices de los errores coincidan con las filas visibles*/
        form.getProyectos().removeIf(this::filaVacia);

        if (form.getNombre().isBlank()) {
            errores.put("nombre", "error.obligatorio");
        }
        if (form.getTitular().isBlank()) {
            errores.put("titular", "error.obligatorio");
        }
        if (form.getPresentacion().isBlank()) {
            errores.put("presentacion", "error.obligatorio");
        }
        // El correo es opcional: solo se valida el formato si se ha rellenado
        if (!form.getCorreo().isBlank()
                && !form.getCorreo().matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            errores.put("correo", "error.correo");
        }

        // Cada fila de proyecto
        for (int i = 0; i < form.getProyectos().size(); i++) {
            ProyectoForm p = form.getProyectos().get(i);
            String prefijo = "proyectos" + i + ".";

            if (p.getTitulo().isBlank()) {
                errores.put(prefijo + "titulo", "error.obligatorio");
            }
            if (p.getDescripcion().isBlank()) {
                errores.put(prefijo + "descripcion", "error.obligatorio");
            }

            // Año: obligatorio y numérico (se conserva como texto en el formulario)
            if (p.getAnio().isBlank()) {
                errores.put(prefijo + "anio", "error.obligatorio");
            } else {
                try {
                    Integer.parseInt(p.getAnio().trim());
                } catch (NumberFormatException e) {
                    errores.put(prefijo + "anio", "error.anio");
                }
            }

            // Categoría y estado: obligatorios y con un valor permitido
            if (p.getCategoria().isBlank()) {
                errores.put(prefijo + "categoria", "error.obligatorio");
            } else if (!CATEGORIAS.contains(p.getCategoria())) {
                errores.put(prefijo + "categoria", "error.categoria");
            }
            if (p.getEstado().isBlank()) {
                errores.put(prefijo + "estado", "error.obligatorio");
            } else if (!ESTADOS.contains(p.getEstado())) {
                errores.put(prefijo + "estado", "error.estado");
            }
        }
    }
}
