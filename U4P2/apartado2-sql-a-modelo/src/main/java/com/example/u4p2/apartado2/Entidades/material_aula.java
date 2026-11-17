package com.example.u4p2.apartado2.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

@Entity
@Table(name = "material_aula")
@Getter
@Setter
@NoArgsConstructor

public class material_aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 12, unique = true)
    private String referencia;

    @Column(length = 80)
    private String nombre_material;

    @Column(length = 250)
    private String descripcion;

    @Column(precision = 8, scale = 2)
    private Integer coste_reposicion;

    @Column()
    private short unidades;
}
