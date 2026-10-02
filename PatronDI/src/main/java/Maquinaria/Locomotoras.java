package Maquinaria;
import personal.Mecanicos;

public class Locomotoras {
    private String Matricula;
    private int potencia;
    private int añoFabricacion;
    private Mecanicos nombreMecanico;

    public Locomotoras(String matricula, int potencia, int añoFabricacion, Mecanicos nombreMecanico) {
        Matricula = matricula;
        this.potencia = potencia;
        this.añoFabricacion = añoFabricacion;
        this.nombreMecanico = nombreMecanico;
    }
}
