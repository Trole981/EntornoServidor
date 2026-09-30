package org.example;

import DAO.LibroDAO;
import DAO.LibroDAOImpl;
import Modelo.Libro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        LibroDAO libros= new LibroDAOImpl();

        libros.agregar(new Libro(1,"Geronimo Stilton 10", "Williams Vangeance", 2015));
        libros.agregar(new Libro(2, "Cien años de soledad", "Gabriel García Márquez", 1967));
        libros.agregar(new Libro(3, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

        System.out.println("Todos los libros:");
        for (Libro l:libros.obtenerTodos()){
            System.out.println("- " + l.toString());
        }
        System.out.println("");
        Libro l=libros.obtenerPorld(2);
        if(l!=null){
            System.out.println("Libro con ID: " + l.getId());
            System.out.println(l.toString());
        }else{
            System.out.println("No existe un Libro con esa ID.");
        }
        System.out.println("");
        l.setAnioPublicacion(l.getAnioPublicacion()+2);
        System.out.println("Actualizando el libro con ID: " + l.getId());
        libros.actualizar(l);

        System.out.println("");

        System.out.println("Todos los libros después de actualizar: ");
        for (Libro li:libros.obtenerTodos()){
            System.out.println("- " + li.toString());
        }

        System.out.println("");

        System.out.println("Eliminando Libro con ID: " + 1);
        libros.eliminar(1);

        System.out.println("");

        System.out.println("Todos los libros despues de eliminar:");
        for (Libro li:libros.obtenerTodos()){
            System.out.println("- " + li.toString());
        }
    }
}
