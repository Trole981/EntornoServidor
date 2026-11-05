package com.gonzalo.portfolio.model;

public class Estudio {
    private String curso;
    private String nivel;
    private int anioInicio;
    private Integer anioFin;

    public Estudio(String curso, String nivel, int anioInicio, Integer anioFin) {
        this.curso = curso;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.nivel = nivel;
    }

    public String getNivel() { return nivel; }

    public String getCurso() {
        return curso;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public Integer getAnioFin() {
        return anioFin;
    }
}
