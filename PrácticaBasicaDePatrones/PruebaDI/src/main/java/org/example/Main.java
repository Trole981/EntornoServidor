package org.example;

import Casas.Casa;
import Casas.Pared;
import Casas.TejadoTejas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // Casa 1: paredes con altura por defecto
        Casa casa1 = new Casa(120.0,
                new TejadoTejas(),
                new Pared(), new Pared(), new Pared(), new Pared());

        // Casa 2: paredes con alturas distintas
        Casa casa2 = new Casa(85.5,
                new TejadoTejas(),
                new Pared(3.0), new Pared(3.0), new Pared(2.8), new Pared(2.8));

        casa1.mostrarInfo();
        System.out.println();
        casa2.mostrarInfo();
    }
}
