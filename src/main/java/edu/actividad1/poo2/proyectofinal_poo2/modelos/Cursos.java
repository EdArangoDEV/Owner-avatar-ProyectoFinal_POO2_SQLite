package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cursos {
    private SimpleIntegerProperty Id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty descripcion;

    public Cursos() {
        Id = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
    }

    public Cursos(SimpleIntegerProperty id, SimpleStringProperty nombre, SimpleStringProperty descripcion) {
        Id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public int getId() {
        return Id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return Id;
    }

    public void setId(int id) {
        this.Id.set(id);
    }



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
