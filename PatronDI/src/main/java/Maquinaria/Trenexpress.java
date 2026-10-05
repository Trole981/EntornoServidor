package Maquinaria;

import personal.Maquinistas;

import java.util.ArrayList;

public class Trenexpress extends tren{
    private ArrayList<Vagones> Vagones;

    public Trenexpress(Locomotoras matriculaLocomotora, Maquinistas Maquinista) {
        super(matriculaLocomotora, Maquinista);
        Vagones = new ArrayList<Vagones>();
        Vagones v1 = new Vagones(500, 200, "Carbon");
        Vagones v2 = new Vagones(400, 150, "Lenia");
        Vagones v3 = new Vagones(900, 500, "metales");
        Vagones.add(v1);
        Vagones.add(v2);
        Vagones.add(v3);
    }
}
