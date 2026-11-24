package com.gonzalo.u4p3.controlador;


import com.gonzalo.u4p3.dto.ActividadFormulario;
import com.gonzalo.u4p3.models.Actividad;
import com.gonzalo.u4p3.servicio.ActividadServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/**
 * Une las peticiones HTTP con el servicio y la plantilla Thymeleaf.
 * No contiene acceso a datos: eso corresponde al servicio y al repositorio.
 */
@Controller
public class ActividadControlador {
    private final ActividadServicio actividadServicio;

    public ActividadControlador(ActividadServicio actividadServicio) {
        this.actividadServicio=actividadServicio;
    }
    /** Muestra el listado completo y el formulario de alta en la misma página. */

    @GetMapping("/")
    public String mostrarActividades(Model model){
        prepararPagina(model, new ActividadFormulario());
        return "actividades";
    }
    /** Valida el formulario; si es correcto lo guarda, y si no, vuelve a mostrarlo con los errores. */

    @PostMapping("/actividades")
    public String registrarActividad(@Valid @ModelAttribute("nuevaActividad") ActividadFormulario formulario,
                                     BindingResult resultado, Model model) {
        if (resultado.hasErrors()) {
            // Al volver a pintar la página hay que cargar otra vez todos los datos
            // que necesita la vista; no basta con conservar solo los campos del formulario.
            prepararPagina(model, formulario);
            return "actividades";
        }
        actividadServicio.registrar(
                formulario.getTitulo(),
                formulario.getDescripcion(),
                formulario.getFecha(),
                formulario.getDuracionMinutos(),
                formulario.getPrecio(),
                formulario.getAforo(),
                formulario.getInscripcionAbierta());
        // Post/Redirect/Get: evita repetir el alta si se recarga la página.
            return "redirect:/";
    }
    /** Datos comunes que necesita la vista, tanto en la carga inicial como al mostrar errores. */

    private void prepararPagina(Model model, ActividadFormulario actividadFormulario){
        List<Actividad> actividades=actividadServicio.obtenerTodos();
        model.addAttribute("actividades", actividades);
        model.addAttribute("nuevaActividad", actividadFormulario);
    }
}
