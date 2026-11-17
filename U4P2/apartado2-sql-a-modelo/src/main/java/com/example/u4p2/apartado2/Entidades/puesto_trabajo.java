package com.example.u4p2.apartado2.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puesto_trabajo")
@Getter
@Setter
@NoArgsConstructor

public class puesto_trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, unique = true)
    private String codigo_puesto;

    @Column(length = 60)
    private String denominacion;

    @Column()
    private Integer planta;

    @Column()
    private boolean tiene_electricidad;
}