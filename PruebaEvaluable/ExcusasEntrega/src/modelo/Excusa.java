/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excusasentrega.DAO.*;
import excusasentrega.*;
import java.util.Date;
/**
 *
 * @author dam1
 */
public class Excusa {
    private int id;
    private String alumno;
    private String curso;
    private String excusa;
    private int dias_retraso;
    private int credibilidad;
    private Date fecha_entrega;
    private int aprobada_por_profesor;
    private int nivel_drama;

    public Excusa() {
    }

    
    
    public Excusa(int id, String alumno, String curso, String excusa, int dias_retraso, int credibilidad, Date fecha_entrega, int aprobada_por_profesor, int nivel_drama) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
        this.excusa = excusa;
        this.dias_retraso = dias_retraso;
        this.credibilidad = credibilidad;
        this.fecha_entrega = fecha_entrega;
        this.aprobada_por_profesor = aprobada_por_profesor;
        this.nivel_drama = nivel_drama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getExcusa() {
        return excusa;
    }

    public void setExcusa(String excusa) {
        this.excusa = excusa;
    }

    public int getDias_retraso() {
        return dias_retraso;
    }

    public void setDias_retraso(int dias_retraso) {
        this.dias_retraso = dias_retraso;
    }

    public int getCredibilidad() {
        return credibilidad;
    }

    public void setCredibilidad(int credibilidad) {
        this.credibilidad = credibilidad;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getAprobada_por_profesor() {
        return aprobada_por_profesor;
    }

    public void setAprobada_por_profesor(int aprobada_por_profesor) {
        this.aprobada_por_profesor = aprobada_por_profesor;
    }

    public int getNivel_drama() {
        return nivel_drama;
    }

    public void setNivel_drama(int nivel_drama) {
        this.nivel_drama = nivel_drama;
    }
    
    
}
