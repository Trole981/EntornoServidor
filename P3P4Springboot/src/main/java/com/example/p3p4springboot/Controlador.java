package com.example.p3p4springboot;


import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.temporal.ChronoUnit;

/**
 * Recibe formularios de ejemplo, valida los datos y los presenta en otras vistas.
 * Ninguna solicitud se almacena de forma permanente.
 */
@Controller
public class Controlador {

    private static final String[][] CATALOGO = {
            {"PORTATIL", "Ordenador Portátil", "Portátil i7 con 16GB de RAM ideal para desarrollo."},
            {"MICRO", "Micrófono USB", "Micrófono de condensador para grabación de audio de alta calidad."},
            {"CAMARA", "Cámara Réflex", "Cámara digital para producción de videotutoriales."}
    };

    private String[] buscarMaterial(String codigo) {
        // Evitamos errores si el código recibido es nulo
        if (codigo == null) {
            return null;
        }

        // Recorremos cada fila del array bidimensional
        for (String[] fila : CATALOGO) {
            // fila[0] contiene el código del recurso
            if (fila[0].equalsIgnoreCase(codigo)) {
                return fila; // Retorna la fila encontrada {código, nombre, descripción}
            }
        }

        return null; // Si termina el bucle y no lo encuentra, retorna null
    }
    /**
     * Prepara la variante con DTO para un primer envío vacío.
     *
     * @param model modelo MVC con el objeto enlazado y las opciones de los controles
     * @return nombre lógico de la vista del formulario con DTO
     */
    @GetMapping("/")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("materiales", CATALOGO);
        return "catalogo";
    }

    @GetMapping("/materiales/{codigo}")
    public String mostrarFicha(@PathVariable String codigo, @RequestParam(required = false, defaultValue = "general") String turno, Model model) {
       String[] materialEncontrado = buscarMaterial(codigo);

       if(materialEncontrado == null){
           throw new org.springframework.web.server.ResponseStatusException(
                   org.springframework.http.HttpStatus.NOT_FOUND, "El material no existe"
           );
       }

       model.addAttribute("material", materialEncontrado);
       model.addAttribute("turno", turno);
       return "ficha";
    }

    @GetMapping("/solicitud/nueva")
    public String mostrarFormulario(
            @RequestParam(required = false) String codigo,
            Model model) {

        Solicitud nuevaSolicitud = new Solicitud();

        // Si pasamos un código por la URL (ej: /solicitud/nueva?codigo=PORTATIL),
        // lo pre-cargamos en el objeto para que el formulario ya lo tenga seleccionado
        if (codigo != null && !codigo.isEmpty()) {
            nuevaSolicitud.setMaterial(codigo);
        }

        // Pasamos el objeto solicitud vacío (o pre-rellenado) al formulario
        model.addAttribute("solicitud", nuevaSolicitud);

        // Pasamos el catálogo completo para poder pintar el <select> de materiales del formulario
        model.addAttribute("materiales", CATALOGO);

        return "formulario";
    }

    @PostMapping("/solicitudes")
    public String procesarFormulario(
        @Valid @ModelAttribute("solicitud") Solicitud solicitud,
        BindingResult bindingResult, Model model) {

        // 1. Primera validación: Comprobar las anotaciones del objeto (@NotBlank, @Email, etc.)
        if(bindingResult.hasErrors()){
            // Si hay errores de formato, volvemos a pasar el catálogo y recargamos el formulario
            model.addAttribute("materiales", CATALOGO);
            return "formulario";
        }

        // 2. OBSTÁCULO A: Validaciones automáticas de las anotaciones de Java (Paso 12)
        if (bindingResult.hasErrors()) {
            return "formulario"; // Detiene el método aquí y vuelve al formulario
        }

        // 3. Segunda validación: Comprobar si el código del material existe en nuestro catálogo
        String[] materialEncontrado = buscarMaterial(solicitud.getMaterial());

        if (materialEncontrado == null) {
            // Si no existe, creamos un error personalizado manualmente y lo asociamos al campo
            bindingResult.addError(new FieldError(
                    "solicitud",
                    "codigoMaterial",
                    "El material seleccionado no es válido o ya no está disponible en nuestro catálogo"
            ));

            // Volvemos a pasar el catálogo y recargamos el formulario mostrando este nuevo error
            model.addAttribute("materiales", CATALOGO);
            return "formulario";
        }

        // 4. Si todo está correcto: Pasamos los datos validados a la vista de éxito
        model.addAttribute("solicitud", solicitud);
        // Pasamos también el nombre real del material para que quede más profesional en el resumen
        model.addAttribute("nombreMaterial", materialEncontrado[1]);

        long diasPrestamo = java.time.temporal.ChronoUnit.DAYS.between(
                solicitud.getFechaRecogida(),
                solicitud.getFechaDevolucion()
        ) + 1; // Se suma 1 porque se cuentan ambos extremos (mismo día = 1 día)

        long diasUnidad = diasPrestamo * solicitud.getUnidades();

        // Pasar datos finales al modelo
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("nombreMaterial", materialEncontrado[1]); // Posición 1 del array es el Nombre
        model.addAttribute("dias", diasPrestamo);
        model.addAttribute("diasUnidad", diasUnidad);

        // Paso 15: Ir a la vista de éxito
        return "resumen";  // Nombre lógico de la vista del Paso 13
    }
}