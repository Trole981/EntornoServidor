/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excusasentrega;
import modelo.Excusa;
import excusasentrega.DAO.ExcusaDAO;
import excusasentrega.DAO.ExcusaDAOImpl;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author dam1
 */
public class excusasentrega {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio1", "root", "JBESSJ");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            
            connection.close();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        ExcusaDAO excusaDAO = new ExcusaDAOImpl();
        
        System.out.println("\n-------- Excusas Simple --------");
        List<Excusa> excusas = excusaDAO.consultaSimple();
        for(Excusa e:excusas){
            System.out.println("nobre = " + e.getAlumno());
            System.out.println("excusa = " + e.getExcusa());
            System.out.println("Dias de retraso = " + e.getDias_retraso());
            System.out.println("nivel_drama = " + e.getNivel_drama());
        }
        
        System.out.println("\n-------- Excusas LIKE --------");
        List<Excusa> excusas2 = excusaDAO.consultaLike();
        for(Excusa e:excusas2){
            System.out.println("nobre = " + e.getAlumno());
            System.out.println("excusa = " + e.getExcusa());
            System.out.println("Dias de retraso = " + e.getDias_retraso());
            System.out.println("nivel_drama = " + e.getNivel_drama());
        }
        
        System.out.println("\n-------- Excusas Null --------");
        List<Excusa> excusas3 = excusaDAO.consultaNull();
        for(Excusa e:excusas3){
            System.out.println("nobre = " + e.getAlumno());
            System.out.println("excusa = " + e.getExcusa());
            System.out.println("Dias de retraso = " + e.getDias_retraso());
            System.out.println("nivel_drama = " + e.getNivel_drama());
        }
        
        
        System.out.println("\n-------- Excusas Avanzadas --------");
        List<Excusa> excusas4 = excusaDAO.consultaAvanzada();
        for(Excusa e:excusas4){
            System.out.println("nobre = " + e.getAlumno());
            System.out.println("excusa = " + e.getExcusa());
            System.out.println("Dias de retraso = " + e.getDias_retraso());
            System.out.println("nivel_drama = " + e.getNivel_drama());
        }
        
    }
    
}
