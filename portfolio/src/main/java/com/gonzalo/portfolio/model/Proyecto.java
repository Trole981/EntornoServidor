package com.gonzalo.portfolio.model;

import java.util.List;

public class Proyecto {
    private String titulo;
    private int anio;
    private String categoria;
    private String descripcion;
    private String estado;
    private List<String> tecnologias;
    private String enlaces;
    private String imagen;

    public Proyecto(String titulo, int anio, String categoria, String descripcion, String estado, List<String> tecnologias, String enlaces, String imagen) {
        this.titulo = titulo;
        this.anio = anio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tecnologias = tecnologias;
        this.enlaces = enlaces;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public String getEnlaces() {
        return enlaces;
    }

    public String getImagen() {
        return imagen;
    }
}
