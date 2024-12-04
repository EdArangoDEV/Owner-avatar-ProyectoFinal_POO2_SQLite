package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ConsultaAsignacion {

    public SimpleIntegerProperty idCurso;
    public SimpleIntegerProperty carnet;
    public SimpleStringProperty nombre;
    public SimpleStringProperty correo;
    public SimpleStringProperty curso;
    public SimpleStringProperty fecha;
    public SimpleStringProperty solvencia;


    public ConsultaAsignacion() {
        this.carnet = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.correo = new SimpleStringProperty();
        this.fecha = new SimpleStringProperty();
        this.curso = new SimpleStringProperty();
        this.solvencia = new SimpleStringProperty();
        this.idCurso = new SimpleIntegerProperty();
    }


    public ConsultaAsignacion(SimpleIntegerProperty carnet, SimpleStringProperty nombre, SimpleStringProperty correo, SimpleStringProperty fecha,  SimpleStringProperty curso, SimpleStringProperty solvencia, SimpleIntegerProperty idCurso) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.correo = correo;
        this.fecha = fecha;
        this.curso = curso;
        this.solvencia = solvencia;
        this.idCurso = idCurso;
    }


    public int getCarnet() {
        return carnet.get();
    }

    public SimpleIntegerProperty carnetProperty() {
        return carnet;
    }

    public void setCarnet(int carnet) {
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

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
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

    public int getIdCurso() {
        return idCurso.get();
    }

    public SimpleIntegerProperty idCursoProperty() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso.set(idCurso);
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

    @Override
    public String toString() {
        return "ConsultaAsignacion{" +
                "carnet=" + carnet +
                ", nombre=" + nombre +
                ", correo=" + correo +
                ", curso=" + curso +
                ", fecha=" + fecha +
                ", solvencia=" + solvencia +
                '}';
    }
}
