/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excusasentrega.DAO;

import modelo.Excusa;
import excusasentrega.*;
import java.util.List;

/**
 *
 * @author dam1
 */
public interface ExcusaDAO {
    List<Excusa> consultaSimple();
    List<Excusa> consultaLike();
    List<Excusa> consultaNull();
    List<Excusa> consultaAvanzada();
}
