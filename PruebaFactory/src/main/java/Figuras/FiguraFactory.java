package Figuras;

public class FiguraFactory {
    private FiguraFactory() {
    }

    public static Figura crearFigura(String tipo, String color) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de figura no puede ser null");
        }

        switch (tipo.toLowerCase()) {
            case "triangulo":
                return new Triangulo(color);
            case "rectangulo":
                return new Rectangulo(color);
            case "circulo":
                return new Circulo(color);
            case "cuadrado":
                return new Cuadrado(color);
            default:
                throw new IllegalArgumentException("Tipo de figura desconocido: " + tipo);
        }
    }
}
