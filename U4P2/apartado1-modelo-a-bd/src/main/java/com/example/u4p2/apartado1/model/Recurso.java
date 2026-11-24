package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Recurso")
@Getter
@Setter
@NoArgsConstructor

public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, unique = true)
    private String titulo;

    @Column(nullable = true, length = 300)
    private String descripcion;

    @Column()
    private LocalDate fecha;

    @Column(precision = 5, scale = 2)
    private BigDecimal duracionMinutos;

    @Column(precision = 5)
    private int precio;

    @Column(precision = 3)
    private Integer aforo;

    @Column()
    private boolean inscripcionAbierta;
}