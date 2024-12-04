package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Estudiante {
    private SimpleIntegerProperty Id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty carnet;
    public SimpleStringProperty telefono;
    public SimpleStringProperty direccin;
    public SimpleStringProperty email;

    public Estudiante() {
        Id = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.carnet = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.direccin = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
    }


    public Estudiante(SimpleStringProperty nombre, SimpleStringProperty carnet, SimpleStringProperty telefono, SimpleStringProperty direccin, SimpleStringProperty email) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.telefono = telefono;
        this.direccin = direccin;
        this.email = email;
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

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getCarnet() {
        return carnet.get();
    }

    public SimpleStringProperty carnetProperty() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet.set(carnet);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public SimpleStringProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getDireccin() {
        return direccin.get();
    }

    public SimpleStringProperty direccinProperty() {
        return direccin;
    }

    public void setDireccin(String direccin) {
        this.direccin.set(direccin);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
