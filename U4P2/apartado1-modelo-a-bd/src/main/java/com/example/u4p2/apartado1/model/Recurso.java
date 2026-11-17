package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Recurso")
@Getter
@Setter
@NoArgsConstructor

public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 12, unique = true)
    private String codigo;

    @Column(length = 80)
    private String nombre;

    @Column(nullable = true, length = 250)
    private String descripcion;

    @Column(precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    @Column()
    private boolean prestable;
}