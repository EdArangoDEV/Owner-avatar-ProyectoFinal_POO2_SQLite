package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PruebaAsignacion {
    SimpleStringProperty carnet;
    SimpleStringProperty nombre;
    SimpleStringProperty correo;
    SimpleStringProperty fechaAsignacion;
    SimpleStringProperty solvencia;
    SimpleStringProperty curso;

    public PruebaAsignacion() {
        this.carnet = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.correo = new SimpleStringProperty();
        this.fechaAsignacion = new SimpleStringProperty();
        this.solvencia = new SimpleStringProperty();
        this.curso = new SimpleStringProperty();
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

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getCorreo() {
        return correo.get();
    }

    public SimpleStringProperty correoProperty() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public String getFechaAsignacion() {
        return fechaAsignacion.get();
    }

    public SimpleStringProperty fechaAsignacionProperty() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion.set(fechaAsignacion);
    }

    public String getSolvencia() {
        return solvencia.get();
    }

    public SimpleStringProperty solvenciaProperty() {
        return solvencia;
    }

    public void setSolvencia(String solvencia) {
        this.solvencia.set(solvencia);
    }

    public String getCurso() {
        return curso.get();
    }

    public SimpleStringProperty cursoProperty() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso.set(curso);
    }
}
