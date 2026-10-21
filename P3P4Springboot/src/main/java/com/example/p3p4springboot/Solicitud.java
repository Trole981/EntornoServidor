package com.example.p3p4springboot;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Objeto temporal para enlazar campos de una petición web.
 *
 * No es una entidad ni se guarda en una base de datos: Spring crea y enlaza
 * una instancia para cada petición. Los getters y setters permiten el binding.
 */
public class Solicitud {

    @NotBlank(message = "El nombre del solicitante no puede estar vacío")
    @Size(max = 60, message = "El nombre no puede superar los 60 caracteres")
    private String nombre;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe introducir un formato de correo electrónico válido")
    @Size(max = 120, message = "El correo no puede superar los 120 caracteres")
    private String correo;

    @NotBlank(message = "El código del material es obligatorio")
    private String material;

    // Usamos Integer en lugar de int primitivo para que @NotNull intercepte el campo vacío de forma segura
    @NotNull(message = "Debes indicar el número de unidades")
    @Min(value = 1, message = "El mínimo es 1 unidad")
    @Max(value = 3, message = "El máximo permitido son 3 unidades")
    private Integer unidades;

    // @DateTimeFormat ISO mapea correctamente el formato yyyy-MM-dd que envía el navegador
    @NotNull(message = "La fecha de recogida es obligatoria")
    @FutureOrPresent(message = "La fecha de recogida debe ser hoy o una fecha futura")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecogida;

    @NotNull(message = "La fecha de devolución es obligatoria")
    @FutureOrPresent(message = "La fecha de devolución debe ser hoy o una fecha futura")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevolucion;

    @NotBlank(message = "El motivo de la solicitud es obligatorio")
    @Size(min = 30, max = 400, message = "El motivo debe tener entre 30 y 400 caracteres")
    private String motivo;

    @AssertTrue(message = "Debes aceptar las normas de uso de la sala para continuar")
    private boolean aceptaNormas;

    private String turno; // Se mantiene del flujo de la ficha técnica

    // Constructor vacío por defecto (Obligatorio para Spring)
    public Solicitud() {
    }

    // --- GETTERS Y SETTERS ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public Integer getUnidades() { return unidades; }
    public void setUnidades(Integer unidades) { this.unidades = unidades; }

    public LocalDate getFechaRecogida() { return fechaRecogida; }
    public void setFechaRecogida(LocalDate fechaRecogida) { this.fechaRecogida = fechaRecogida; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    // Importante: El getter de un boolean de Spring para checkbox debe empezar por 'is'
    public boolean isAceptaNormas() { return aceptaNormas; }
    public void setAceptaNormas(boolean aceptaNormas) { this.aceptaNormas = aceptaNormas; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}