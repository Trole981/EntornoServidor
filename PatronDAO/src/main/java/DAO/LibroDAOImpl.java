package DAO;

import Modelo.Libro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LibroDAOImpl implements LibroDAO{

    private final Map<Integer, Libro> libros = new LinkedHashMap<>();

    @Override
    public List<Libro> obtenerTodos() {
        return List.copyOf(libros.values());
    }

    @Override
    public Libro obtenerPorld(int id) {
        Libro libro=libros.get(id);
        if (libro==null){
            throw new IllegalArgumentException("No existe un libro con la ID: " + id);
        }
        return libro;
    }

    @Override
    public void agregar(Libro libro) {
        if (libros.containsKey(libro.getId())){
            throw  new IllegalArgumentException("Ya existe un libro con la ID: " + libro.getId());
        }
        libros.put(libro.getId(), libro);
    }

    @Override
    public void actualizar(Libro libro) {
        obtenerPorld(libro.getId());
        libros.put(libro.getId(), libro);
        System.out.println("Libro: " + libro.getTitulo() + " Actualizado correctamente");
    }

    @Override
    public void eliminar(int id) {
        obtenerPorld(id);
        libros.remove(id);
        System.out.println("Libro eliminado correctamente");
    }
}
