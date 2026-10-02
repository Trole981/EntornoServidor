package Maquinaria;

import personal.Maquinistas;

import java.util.ArrayList;

public class Trenes {
    private Locomotoras MatriculaLocomotora;
    private ArrayList<Vagones> NumVagones;
    private Maquinistas dniMaquinista;

    public Trenes(Locomotoras matriculaLocomotora, Maquinistas dniMaquinista) {
        MatriculaLocomotora = matriculaLocomotora;
        NumVagones =  new ArrayList<>();
        this.dniMaquinista = dniMaquinista;
    }

    public void agregarVagon(Vagones vagon) {
        if (NumVagones.size() < 5) {
            NumVagones.add(vagon);
        }
    }
}
