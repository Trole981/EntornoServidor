package com.gonzalo.portfolio.model;

public class Experiencia {
    private String Descripcion;
    private String empresa;
    private String duracion;

    public Experiencia(String descripcion, String empresa, String duracion) {
        Descripcion = descripcion;
        this.empresa = empresa;
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDuracion() {
        return duracion;
    }
}
