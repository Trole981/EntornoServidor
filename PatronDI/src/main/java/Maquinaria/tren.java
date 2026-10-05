package Maquinaria;

import personal.Maquinistas;
import personal.Mecanicos;

public class tren {
    private Locomotoras MatriculaLocomotora;
    private Maquinistas Maquinista;

    public tren(Locomotoras matriculaLocomotora, Maquinistas Maquinista) {
        this.MatriculaLocomotora = matriculaLocomotora;
        this.Maquinista = Maquinista;
    }

    public tren() {
        this.Maquinista = new Maquinistas("Gonzalo Barreiro", "59687447R", 9500, "Alto");
        this.MatriculaLocomotora = new Locomotoras("5874ERD", 580, 1860, new Mecanicos("Asier Velardo", 957412358, "Trenes"));
    }
}
