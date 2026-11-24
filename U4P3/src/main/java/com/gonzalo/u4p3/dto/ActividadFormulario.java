package com.gonzalo.u4p3.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * Datos que envía el formulario de alta. No es una entidad: no incluye el id,
 * para que el cliente no pueda elegir la clave primaria generada por la base de datos.
 */
@Getter
@Setter
@NoArgsConstructor
public class ActividadFormulario {
    @NotBlank(message = "Escribe el título de la actividad.")
    @Size(max = 80, message = "El título no puede superar los 80 caracteres.")
    private String titulo;

    @Size(max = 300, message = "Descripción, no puede pasar los 300 caracteres..")
    private String descripcion;

    @NotNull(message = "Indica la fecha.")
    private LocalDate fecha;

    @NotNull(message = "Duracion en minutos.")
    @Min(value = 15, message = "La activiad debe de durar 15 minutos")
    @Max(value = 480, message = "La actividad no puede drar más de 480 minutos.")
    private Integer duracionMinutos;

    @NotNull(message = "Indica el precio.")
    @DecimalMin(value = "0.00", message = "El precio no puede ser negativo.")
    @Digits(integer = 3, fraction = 2, message = "Usa hasta 3 cifras enteras y 2 decimales.")
    private BigDecimal precio;

    @NotNull(message = "Indica cuántas personas caben.")
    @Min(value = 1, message = "Tiene que caber al menos alguien.")
    @Max(value = 200, message = "El aforo máximo son de 200 personas.")
    private Integer aforo;

    @NotNull(message = "Indica si la inscripción está abierta.")
    private Boolean inscripcionAbierta;
}
