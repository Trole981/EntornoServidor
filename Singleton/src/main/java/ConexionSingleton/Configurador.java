package ConexionSingleton;

public class Configurador {
    private String configuracion;

    private static final Configurador INSTANCIA = new Configurador();

    private Configurador() {

    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public static Configurador obtenerInstancia(){
        return INSTANCIA;
    }
}
