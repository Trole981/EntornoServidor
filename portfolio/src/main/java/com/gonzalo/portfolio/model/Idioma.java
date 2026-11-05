package com.gonzalo.portfolio.model;

public class Idioma {
    private String nombre;
    private String nivel;

    public Idioma(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}
