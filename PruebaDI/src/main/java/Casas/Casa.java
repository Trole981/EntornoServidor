package Casas;

public class Casa {

    private Double area;
    private Tejado tejado;
    private Pared[] paredes;

    public Casa(Double area, Tejado tejado,
                Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
        this.area = area;
        this.tejado = tejado;
        this.paredes = new Pared[] { pared1, pared2, pared3, pared4 };
    }

    public void mostrarInfo() {
        System.out.println("Casa de " + area + " m2");
        for (int i = 0; i < paredes.length; i++) {
            System.out.println("  Pared " + (i + 1) + ": altura " + paredes[i].getAltura() + " m");
        }
        tejado.darSoporte();
    }
}
