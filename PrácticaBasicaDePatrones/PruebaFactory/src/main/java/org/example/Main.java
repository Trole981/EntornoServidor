package org.example;
import Figuras.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Figura triangulo  = FiguraFactory.crearFigura("triangulo", "rojo");
        Figura rectangulo = FiguraFactory.crearFigura("rectangulo", "azul");
        Figura circulo    = FiguraFactory.crearFigura("circulo", "verde");
        Figura cuadrado   = FiguraFactory.crearFigura("cuadrado", "amarillo");

        triangulo.dibujarFigura();
        rectangulo.dibujarFigura();
        circulo.dibujarFigura();
        cuadrado.dibujarFigura();
    }
}
