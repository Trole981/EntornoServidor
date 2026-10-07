package Figuras;

public class Circulo extends Figura {

    public Circulo(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Dibujando un círculo de color " + getColor());
    }
}
