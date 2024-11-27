package edu.actividad1.poo2.proyectofinal_poo2;

import edu.actividad1.poo2.proyectofinal_poo2.controladores.ApplicationController;
import edu.actividad1.poo2.proyectofinal_poo2.controladores.AsignacionController;
import edu.actividad1.poo2.proyectofinal_poo2.controladores.CursosController;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.PruebaAsignacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Application extends javafx.application.Application {

    public Stage principalStage;
    public Stage cursosStage;
    public Stage asignacionesStage;


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 280);

        this.principalStage = stage;
        stage.setTitle("Inicio");
        stage.setScene(scene);

        ApplicationController appC = fxmlLoader.getController();
        appC.setMain(this);

//        asignacionEstudianteP("si");

        stage.show();
    }

    public void cargarCursos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("cursos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 520);

        CursosController cursosC = fxmlLoader.getController();
        cursosC.setMain(this);

        Stage cursosStage = new Stage();
        this.cursosStage = cursosStage;
        cursosStage.setTitle("Cursos");
        cursosStage.setScene(scene);
        cursosStage.show();
        principalStage.hide();

        cursosStage.setOnCloseRequest(e -> principalStage.show());
    }

    public void cargarAsignaciones() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("asignaciones-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 550);

        AsignacionController asignacionesC = fxmlLoader.getController();
        asignacionesC.setMain(this);

        Stage asignacionesStage = new Stage();
        this.asignacionesStage = asignacionesStage;
        asignacionesStage.setTitle("Asignaciones");
        asignacionesStage.setScene(scene);
        asignacionesStage.show();
        principalStage.hide();

        asignacionesStage.setOnCloseRequest(e -> principalStage.show());
    }

    public static String formatearFecha(LocalDate fecha){
        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatear la fecha
        String fechaFormateada = fecha.format(formato);
        return  fechaFormateada;
    }

    public static ObservableList<PruebaAsignacion> listaAsignaciones = FXCollections.observableArrayList();

//    public static void asignacionEstudianteP(String solvencia){
//        PruebaAsignacion pAsignacion = new PruebaAsignacion();
//        pAsignacion.setCarnet("240001");
//        pAsignacion.setNombre("Prueba 1");
//        pAsignacion.setCorreo("prueba@gamil.com");
//        pAsignacion.setFechaAsignacion(fechaActual());
//        pAsignacion.setSolvencia("si");
//        pAsignacion.setCurso("Algoritmos I");
//        listaAsignaciones.add(pAsignacion);
//    }




    public static void main(String[] args) {
        launch();
    }
}


