package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Espacio")
@Getter
@Setter
@NoArgsConstructor

public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, unique = true)
    private String codigo_espacio;

    @Column(length = 60)
    private String nombre_espacio;

    @Column()
    private Integer aforo;

    @Column()
    private Integer planta;

    @Column()
    private boolean prestable;
}