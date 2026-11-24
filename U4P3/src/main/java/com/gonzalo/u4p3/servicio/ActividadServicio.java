package com.gonzalo.u4p3.servicio;

import com.gonzalo.u4p3.models.Actividad;
import com.gonzalo.u4p3.repositorio.ActividadRepositorio;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ActividadServicio {

    private final ActividadRepositorio actividadRepositorio;

    public ActividadServicio(ActividadRepositorio actividadRepositorio){
        this.actividadRepositorio=actividadRepositorio;
    }

    public List<Actividad> obtenerTodos(){
        return actividadRepositorio.findAll(Sort.by("fecha", "titulo"));
    }
    /**
     * Crea y guarda una actividad con datos ya validados por el controlador.
     * El @Transactional propio sustituye al readOnly de la clase, porque aquí se escribe.
     */
    public Actividad registrar(
        String titulo,
        String descripcion,
        LocalDate fecha,
        Integer duracionMinutos,
        BigDecimal precio,
        Integer aforo,
        boolean inscripcionAbierta) {
        Actividad actividad = new Actividad();
        actividad.setTitulo(titulo);
        // La descripción es opcional: un campo en blanco se guarda como null, no como "".
        actividad.setDescripcion(
        descripcion == null || descripcion.isBlank() ? null : descripcion.trim());
        actividad.setFecha(fecha);
        actividad.setDuracionMinutos(duracionMinutos);
        actividad.setPrecio(precio);
        actividad.setAforo(aforo);
        actividad.setInscripcionAbierta(inscripcionAbierta);

        return actividadRepositorio.save(actividad);
    }
}
