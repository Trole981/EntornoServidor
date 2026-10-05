package org.example;

import Maquinaria.Locomotoras;
import Maquinaria.Trenexpress;
import personal.Maquinistas;
import personal.Mecanicos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Mecanicos juanMecanico = new Mecanicos("Juan Pérez", 654321098, "frenos");
        Maquinistas carlosMaquinista = new Maquinistas("Carlos Gómez", "12345678A", 2500, "Senior");

        Locomotoras locomotora1 = new Locomotoras("LOC-992", 3000, 2022, juanMecanico);

        Trenexpress trenExpress = new Trenexpress(locomotora1, carlosMaquinista);
    }
}
