package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;

public class ApplicationController {


    @FXML
    private Button btnAsignaciones;

    @FXML
    private Button btnCursos;

    @FXML
    private Label lbPrincipal1;

    @FXML
    private Label lbPrincipal2;


    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    @FXML
    void clicCursos(ActionEvent event) throws IOException {
        app.cargarCursos();
    }

    @FXML
    void clicAsignaciones(ActionEvent event) throws IOException {
        app.cargarAsignaciones();
    }

}