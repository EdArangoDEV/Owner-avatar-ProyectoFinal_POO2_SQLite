package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cursos {
    private Integer Id;
    public String nombre;
    public String descripcion;

    public class listaCursos{
        public static ObservableList listaCursos = FXCollections.observableArrayList("Matematica I",
                "Algoritmos I",
                "Logica de programacion I",
                "Ingles I",
                "UML",
                "Base de Datos I",
                "POO I");
    }
}
