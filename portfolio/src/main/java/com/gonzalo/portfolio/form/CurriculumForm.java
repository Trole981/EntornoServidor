package com.gonzalo.portfolio.form;

import java.util.ArrayList;
import java.util.List;

//Base del formulario
public class CurriculumForm {
    private String nombre = "";
    private String titular = "";
    private String presentacion = "";
    private String ciudad = "";
    private String correo = "";
    private List<ProyectoForm> proyectos = new ArrayList<>();

    public CurriculumForm() {
        proyectos.add(new ProyectoForm());
    }

    public List<ProyectoForm> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoForm> proyectos) {
        this.proyectos = proyectos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
