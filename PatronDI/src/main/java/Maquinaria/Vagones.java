package Maquinaria;

class Vagones {
    private int CapacidadMax;
    private int CapacidadActual;
    private String tipoMercancia;

    Vagones(int capacidadMax, int capacidadActual, String tipoMercancia) {
        CapacidadMax = capacidadMax;
        CapacidadActual = capacidadActual;
        this.tipoMercancia = tipoMercancia;
    }
}
