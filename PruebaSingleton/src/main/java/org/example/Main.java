package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Presidente p1 = Presidente.getInstance("Joe", "Biden", 2020);
        // Segundo intento con datos distintos: se ignoran, devuelve la misma instancia
        Presidente p2 = Presidente.getInstance("Donald", "Trump", 2024);

        System.out.println("p1 -> " + p1);
        System.out.println("p2 -> " + p2);

        // Comprobaciones de que solo existe una instancia
        System.out.println("¿p1 == p2? " + (p1 == p2));


        if (p1 == p2) {
            System.out.println("Correcto: solo hay una instancia de Presidente.");
        } else {
            System.out.println("Error: hay más de una instancia.");
        }
    }
}
