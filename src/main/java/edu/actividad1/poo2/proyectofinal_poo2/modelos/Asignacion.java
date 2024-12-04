package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Asignacion {
    public SimpleStringProperty fechaAsignacion;
    public SimpleStringProperty solvencia;
    public SimpleIntegerProperty idEstudiante;
    public SimpleIntegerProperty idCurso;


    public Asignacion() {
        this.fechaAsignacion = new SimpleStringProperty();
        this.solvencia = new SimpleStringProperty();
        this.idEstudiante = new SimpleIntegerProperty();
        this.idCurso = new SimpleIntegerProperty();
    }


    public Asignacion(SimpleStringProperty fechaAsignacion, SimpleStringProperty solvencia, SimpleIntegerProperty idEstudiante, SimpleIntegerProperty idCurso) {
        this.fechaAsignacion = fechaAsignacion;
        this.solvencia = solvencia;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
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

    public int getIdEstudiante() {
        return idEstudiante.get();
    }

    public SimpleIntegerProperty idEstudianteProperty() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante.set(idEstudiante);
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


    @Override
    public String toString() {
        return "Asignacion{" +
                "fechaAsignacion=" + fechaAsignacion +
                ", solvencia=" + solvencia +
                ", idEstudiante=" + idEstudiante +
                ", idCurso=" + idCurso +
                '}';
    }


}
