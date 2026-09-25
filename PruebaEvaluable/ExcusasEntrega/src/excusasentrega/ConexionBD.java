/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excusasentrega;

/**
 *
 * @author dam1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Instancia única de la clase Connection
    private static Connection instancia = null;
    
    // Parámetros de conexión (modifica según tu base de datos)
    private static final String URL = "jdbc:mysql://localhost:3306/ejercicio1";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "JBESSJ";
    
    // Constructor privado para evitar la instanciación con 'new'
    private ConexionBD() {}
    
    // Método público estático para obtener la única instancia
    public static synchronized Connection getInstancia() {
        try {
            if (instancia == null || instancia.isClosed()) {
                instancia = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return instancia;
    }
}