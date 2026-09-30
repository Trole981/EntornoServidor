package DAO;

import Modelo.Libro;

import java.util.List;

public interface LibroDAO {
    List<Libro> obtenerTodos();
    Libro obtenerPorld(int id);
    void agregar(Libro libro);
    void actualizar(Libro libro);
    void eliminar(int id);
}
