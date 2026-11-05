package com.gonzalo.portfolio.model;

public class Habilidad {
    private String habilidad;
    private String nivel;

    public Habilidad(String habilidad, String nivel) {
        this.habilidad = habilidad;
        this.nivel = nivel;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getNivel() {
        return nivel;
    }
}
