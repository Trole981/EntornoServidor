package org.example;

public class Presidente {


    private static Presidente instancia;

    private final String nombre;
    private final String apellidos;
    private final int anioEleccion;


    private Presidente(String nombre, String apellidos, int anioEleccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioEleccion = anioEleccion;
    }

    // Punto de acceso global (double-checked locking)
    public static Presidente getInstance(String nombre, String apellidos, int anioEleccion) {
        if (instancia == null) {
            synchronized (Presidente.class) {
                if (instancia == null) {
                    instancia = new Presidente(nombre, apellidos, anioEleccion);
                }
            }
        }
        return instancia;
    }

    public String getNombre()    {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getAnioEleccion() {
        return anioEleccion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (elegido en " + anioEleccion + ")";
    }
}
