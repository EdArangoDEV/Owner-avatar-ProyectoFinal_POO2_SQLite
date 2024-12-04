package edu.actividad1.poo2.proyectofinal_poo2;

import edu.actividad1.poo2.proyectofinal_poo2.controladores.ApplicationController;
import edu.actividad1.poo2.proyectofinal_poo2.controladores.AsignacionController;
import edu.actividad1.poo2.proyectofinal_poo2.controladores.CursosController;
import edu.actividad1.poo2.proyectofinal_poo2.controladores.ValidacionTextFields;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Scene scene = new Scene(fxmlLoader.load(), 950, 520);

        CursosController cursosC = fxmlLoader.getController();
        cursosC.setMain(this);

        Stage cursosStage = new Stage();
        this.cursosStage = cursosStage;
        cursosStage.setTitle("Verificación de Cursos");
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

    public static ObservableList<Asignacion> listaAsignaciones = FXCollections.observableArrayList();
    public static ObservableList<ConsultaAsignacion> listaConsultaAsignaciones = FXCollections.observableArrayList();

    public static ObservableList<Cursos> listaCursos = FXCollections.observableArrayList();


    public static ObservableList<Cursos> obtenerCursos(){
        listaCursos.clear();

        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Curso;";

        try {
            // hacer la conexion
            Statement instruccion = conexion.getConexion().createStatement();
            // ejecutar la consulta
            ResultSet resultado = instruccion.executeQuery(sql);

            // recorrer resultados
            while (resultado.next()){
                Cursos c = new Cursos();
                c.setId(resultado.getInt("id_curso"));
                c.setNombre(resultado.getString("nombre"));
                c.setDescripcion(resultado.getString("descripcion"));

                listaCursos.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            conexion.closeConexion();
        }


        return  listaCursos;
    }


    public static ObservableList<String> obtenerNombreCursos(){
        ObservableList<String> listNombreCursos = FXCollections.observableArrayList();

        ObservableList<Cursos> listaCursos = FXCollections.observableArrayList();
        listaCursos = obtenerCursos();

        for (Cursos curso : listaCursos){
            listNombreCursos.add(curso.getNombre());
        }

        return listNombreCursos;
    }


    public static String obtenerNombreCurso(int idCurso){
       String nombreC = null;

        ObservableList<Cursos> listaCursos = FXCollections.observableArrayList();
        listaCursos = obtenerCursos();

        for (Cursos curso : listaCursos){
            if(curso.getId() == idCurso)
            {
                nombreC = curso.getNombre();
            }
        }

        return nombreC;
    }


    public static int obtenerIdCurso(String nCurso){
        int idCurso = 0;

        ObservableList<Cursos> listaCursos = FXCollections.observableArrayList();
        listaCursos = obtenerCursos();

        for (Cursos curso : listaCursos){
            if(curso.getNombre().equals(nCurso)){
                idCurso = curso.getId();
            }
        }

        return idCurso;
    }


    public static Estudiante obtenerDatosEstudiante(int carnet){
        Estudiante estudiante = new Estudiante();
//        System.out.println(estudiante);

        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Estudiante WHERE carnet = ?;";

        try {
            // hacer la conexion
            PreparedStatement instruccion = conexion.getConexion().prepareStatement(sql);
            instruccion.setInt(1,carnet);
            // ejecutar la consulta
            ResultSet resultado = instruccion.executeQuery();
//            System.out.println(resultado);

            if (resultado.next()){
                estudiante.setId(Integer.parseInt(resultado.getString("id_estudiante")));
                estudiante.setCarnet(resultado.getString("carnet"));
                estudiante.setNombre(resultado.getString("nombre"));
                estudiante.setTelefono(resultado.getString("telefono"));
                estudiante.setDireccin(resultado.getString("direccion"));
                estudiante.setEmail(resultado.getString("correo"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conexion.closeConexion();
        }

        return estudiante;
    }



    public static int agregarEstudiante(int carnet, String nombre, String telefono, String direccion, String correo){
        int idEstudiante = 0;

        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Estudiante(carnet, nombre, telefono, direccion, correo) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement instruccion = conexion.getConexion().prepareStatement(sql);

            instruccion.setInt(1,carnet);
            instruccion.setString(2,nombre);
            instruccion.setString(3,telefono);
            instruccion.setString(4,direccion);
            instruccion.setString(5,correo);

            int filasAfectadas = instruccion.executeUpdate();

            if(filasAfectadas > 0){
                idEstudiante = obtenerIdEstudiante(carnet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conexion.closeConexion();
        }

        return  idEstudiante;
    }


    public static int obtenerIdEstudiante(int carnet){
        int idEstudiante = 0;

        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Estudiante WHERE carnet = ?;";

        try {
            PreparedStatement instruccion = conexion.getConexion().prepareStatement(sql);
            instruccion.setInt(1,carnet);

            ResultSet resultado = instruccion.executeQuery();

            if(resultado.next()){
                idEstudiante = Integer.parseInt(resultado.getString("id_estudiante"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conexion.closeConexion();
        }

        return idEstudiante;

    }

    public static void agregarAsignacion(Asignacion asignacion){
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Asignacion(fecha, solvente, id_estudiante, id_curso) VALUES (?,?,?,?);";

        try {
            PreparedStatement instruccion = conexion.getConexion().prepareStatement(sql);

            instruccion.setString(1,asignacion.getFechaAsignacion());
            instruccion.setString(2,asignacion.getSolvencia());
            instruccion.setInt(3,asignacion.getIdEstudiante());
            instruccion.setInt(4,asignacion.getIdCurso());

            int filasAfectadas = instruccion.executeUpdate();

//            System.out.println(filasAfectadas > 0 ? asignacion : "No se pudo asignar...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            conexion.closeConexion();
        }

    }

    public static void confirmacionAsignacion(Asignacion asignacion, ObservableList<String> cursos, int carnet){

        ValidacionTextFields validacion = new ValidacionTextFields();
        Estudiante estudiante = obtenerDatosEstudiante(carnet);

        StringBuilder cursosMensaje = new StringBuilder();
        cursos.forEach(curso -> cursosMensaje.append("\t").append(curso).append("\n"));

        validacion.alertConfirmacion("Se asigno el estudiante: " + estudiante.getNombre() + "\nCon carnet: " + estudiante.getCarnet() + "\nEl dia: " + asignacion.getFechaAsignacion() + "\nA los cursos: \n" + cursosMensaje.toString(), "Asignacion" );
    }


    public static void obtenerAsignaciones(){
        listaConsultaAsignaciones.clear();

        Conexion conexion = new Conexion();

        String sql = "SELECT c.id_curso, e.carnet, e.nombre, e.correo, c.nombre as curso, a.fecha, a.solvente FROM Estudiante e INNER JOIN Asignacion a ON e.id_estudiante = a.id_estudiante INNER JOIN Curso c ON a.id_curso = c.id_curso;";

        try {
            Statement instruccion = conexion.getConexion().createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);

            // recorrer resultados
            while (resultado.next()){
                ConsultaAsignacion ca = new ConsultaAsignacion();

                ca.setIdCurso(resultado.getInt("id_curso"));
                ca.setCarnet(resultado.getInt("carnet"));
                ca.setNombre(resultado.getString("nombre"));
                ca.setCorreo(resultado.getString("correo"));
                ca.setCurso(resultado.getString("curso"));
                ca.setFecha(resultado.getString("fecha"));
                ca.setSolvencia(resultado.getString("solvente"));

                listaConsultaAsignaciones.add(ca);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conexion.closeConexion();
        }

//        return  listaConsultaAsignaciones;

    }



    public static void main(String[] args) {
        launch();
    }
}


