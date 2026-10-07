package Casas;

public class Pared {
    private Double altura;

    public Pared() {
        this(2.5); // altura por defecto
    }

    public Pared(Double altura) {
        this.altura = altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
