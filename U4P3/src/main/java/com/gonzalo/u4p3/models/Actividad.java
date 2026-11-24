package com.gonzalo.u4p3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@NoArgsConstructor
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String titulo;

    @Column(length = 300)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Integer duracionMinutos;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer aforo;

    @Column(nullable = false)
    private boolean inscripcionAbierta;
}