/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excusasentrega.DAO;

/**
 *
 * @author dam1
 */
import modelo.Excusa;
import excusasentrega.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class ExcusaDAOImpl implements ExcusaDAO {
    

    @Override
    public List<Excusa> consultaSimple() {
        List<Excusa> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega ORDER BY nivel_drama DESC";
        
        Connection con = ConexionBD.getInstancia();
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Excusa excusa = new Excusa();
                excusa.setId(rs.getInt("id"));
                excusa.setAlumno(rs.getString("alumno"));
                excusa.setCurso(rs.getString("curso"));
                excusa.setExcusa(rs.getString("excusa"));
                excusa.setDias_retraso(rs.getInt("dias_retraso"));
                excusa.setFecha_entrega(rs.getDate("fecha_entrega"));
                excusa.setAprobada_por_profesor(rs.getInt("aprobada_por_profesor"));
                excusa.setNivel_drama(rs.getInt("nivel_drama"));
                lista.add(excusa);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Excusa> consultaLike() {
        List<Excusa> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega WHERE (excusa LIKE'%perro%' OR excusa LIKE '%gato%') AND (dias_retraso BETWEEN 2 AND 6) ORDER BY dias_retraso desc";
        
        Connection con = ConexionBD.getInstancia();
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Excusa excusa = new Excusa();
                excusa.setId(rs.getInt("id"));
                excusa.setAlumno(rs.getString("alumno"));
                excusa.setCurso(rs.getString("curso"));
                excusa.setExcusa(rs.getString("excusa"));
                excusa.setDias_retraso(rs.getInt("dias_retraso"));
                excusa.setFecha_entrega(rs.getDate("fecha_entrega"));
                excusa.setAprobada_por_profesor(rs.getInt("aprobada_por_profesor"));
                excusa.setNivel_drama(rs.getInt("nivel_drama"));
                lista.add(excusa);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Excusa> consultaNull() {
        List<Excusa> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega WHERE (fecha_entrega IS NULL) AND (nivel_drama>9)";
        
        Connection con = ConexionBD.getInstancia();
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Excusa excusa = new Excusa();
                excusa.setId(rs.getInt("id"));
                excusa.setAlumno(rs.getString("alumno"));
                excusa.setCurso(rs.getString("curso"));
                excusa.setExcusa(rs.getString("excusa"));
                excusa.setDias_retraso(rs.getInt("dias_retraso"));
                excusa.setFecha_entrega(rs.getDate("fecha_entrega"));
                excusa.setAprobada_por_profesor(rs.getInt("aprobada_por_profesor"));
                excusa.setNivel_drama(rs.getInt("nivel_drama"));
                lista.add(excusa);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Excusa> consultaAvanzada() {
        List<Excusa> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega WHERE (nivel_drama>8) AND (credibilidad<3) AND (dias_retraso BETWEEN 2 AND 5) AND (excusa LIKE'%perro%') ORDER BY dias_retraso desc";
        
        Connection con = ConexionBD.getInstancia();
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Excusa excusa = new Excusa();
                excusa.setId(rs.getInt("id"));
                excusa.setAlumno(rs.getString("alumno"));
                excusa.setCurso(rs.getString("curso"));
                excusa.setExcusa(rs.getString("excusa"));
                excusa.setDias_retraso(rs.getInt("dias_retraso"));
                excusa.setFecha_entrega(rs.getDate("fecha_entrega"));
                excusa.setAprobada_por_profesor(rs.getInt("aprobada_por_profesor"));
                excusa.setNivel_drama(rs.getInt("nivel_drama"));
                lista.add(excusa);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
        return lista;
    }
}
