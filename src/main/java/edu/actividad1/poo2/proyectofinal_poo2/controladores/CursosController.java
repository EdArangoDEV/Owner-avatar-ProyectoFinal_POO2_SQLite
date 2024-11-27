package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.PruebaAsignacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class CursosController {

    @FXML
    private AnchorPane PaneCursos;

    @FXML
    private Label lbSelecCursos;

    @FXML
    private Label lbCursos;

    @FXML
    private ComboBox<?> comboBCursos;

    @FXML
    private Label lbFechaAsignacion;

    @FXML
    private DatePicker datePAsignacion;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lbTablaAlumnos;

    @FXML
    private TableView<PruebaAsignacion> tablaAsignaciones;

    @FXML
    private TableColumn<?, ?> colCarnet;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colFechaInsc;

    @FXML
    private TableColumn<?, ?> colSolvencia;

    @FXML
    private Label lbGrafSolvencia;

    @FXML
    private PieChart graficoSolvencia;

    @FXML
    private Button btnRegresar;

    String cursoSeleccionado = null;
    String fechaFormateada = null;
    String pholderTablaInicio = "Seleccione un curso o fecha.";


    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    ObservableList listaCursos = Cursos.listaCursos.listaCursos;
//    public ObservableList listaAsignaciones = FXCollections.observableArrayList();
    ObservableList<PruebaAsignacion> listaAsignaciones = app.listaAsignaciones;

    @FXML
    void clicRegresar(ActionEvent event) throws IOException {
        app.principalStage.show();
        app.cursosStage.hide();
    }

    @FXML
    void seleccionCurso(ActionEvent event) {

    }

    @FXML
    void seleccionFecha(ActionEvent event) {

    }

    @FXML
    void clicLimpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    private ObservableList<PruebaAsignacion> filtrarCursos(String curso){
        ObservableList listaFiltradosCursos = FXCollections.observableArrayList();

        if(curso != null){
            for (PruebaAsignacion asignados : listaAsignaciones) {
                String cursoA = asignados.getCurso();
                if (cursoA.equals(curso)){
                    listaFiltradosCursos.add(asignados);
                }
            }
        }

        return listaFiltradosCursos;
    }

    private ObservableList<PruebaAsignacion> filtrarFechas(String fecha){
        ObservableList listaFiltradosFecha = FXCollections.observableArrayList();

            if(fecha != null){
                for (PruebaAsignacion asignados : listaAsignaciones) {
                    String fechaA = asignados.getFechaAsignacion();
                    if (fechaA.equals(fecha)) {
                        listaFiltradosFecha.add(asignados);
                    }
                }
            }

        return listaFiltradosFecha;
    }

    private void llenarTablaAsignados(String curso, String fecha){
        tablaAsignaciones.setItems(null);
//        System.out.println(curso);
//        System.out.println(fecha);
        graficoSolvencia.setData(FXCollections.observableArrayList());

        ObservableList listaFiltrados = FXCollections.observableArrayList();
        if (!listaAsignaciones.isEmpty()){
            ObservableList<PruebaAsignacion> listaFiltradosCurso = FXCollections.observableArrayList();
            ObservableList<PruebaAsignacion> listaFiltradosFecha = FXCollections.observableArrayList();
            ObservableList<PruebaAsignacion> listaFCursoFecha = FXCollections.observableArrayList();

            if(curso != null && fecha != null) {
                listaFiltradosCurso = filtrarCursos(curso);
                if(!listaFiltradosCurso.isEmpty()){
                    for (PruebaAsignacion asignado : listaFiltradosCurso) {
                        String fechaA = asignado.getFechaAsignacion();
                        if (fechaA.equals(fecha))
                            listaFCursoFecha.add(asignado);
                    }

                    if (!listaFCursoFecha.isEmpty()){
                        tablaAsignaciones.setItems(listaFCursoFecha);
                        llenarGraficoPie(listaFiltradosCurso, graficoSolvencia);
                    }
                    else {
                        tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados al curso: " + curso + " y fecha: " + fecha));

                    }
                }
                else {
                    tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados al curso: " + curso + " y fecha: " + fecha));
                }
            } else if (curso != null && fecha == null){
                listaFiltradosCurso = filtrarCursos(curso);
                if (!listaFiltradosCurso.isEmpty()){
                    tablaAsignaciones.setItems(listaFiltradosCurso);
                    llenarGraficoPie(listaFiltradosCurso, graficoSolvencia);
                }
                else {
                    tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados al curso: " + curso));
                }

            } else if (curso == null && fecha != null){
                listaFiltradosFecha = filtrarFechas(fecha);
                if (!listaFiltradosFecha.isEmpty()){
                    tablaAsignaciones.setItems(listaFiltradosFecha);
                } else {
                    tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados en la fecha: " + fecha));
                }
            }
        }
        else {
            tablaAsignaciones.setPlaceholder(new Label("No hay Estudiantes asignados a los cursos"));
        }
    }

    private void llenarGraficoPie(ObservableList<PruebaAsignacion> listAsignados, PieChart graficoSolvencia){

        ObservableList<PieChart.Data> graficoPieSolvencia = FXCollections.observableArrayList();

        int totalSolventes = 0;
        int totalNoSolventes = 0;

        for (PruebaAsignacion estudiante : listAsignados) {
            String solvencia = estudiante.getSolvencia().toLowerCase();
            if (solvencia.equals("si")) {
                totalSolventes ++;
            } else {
                totalNoSolventes ++;
            }
        }

        // Agregar los totales al gráfico
        graficoPieSolvencia.add(new PieChart.Data("Total Solventes " + totalSolventes, totalSolventes));
        graficoPieSolvencia.add(new PieChart.Data("Total No Solventes " + totalNoSolventes, totalNoSolventes));

        graficoSolvencia.setData(graficoPieSolvencia);
    }


    private void limpiarCampos(){
        cursoSeleccionado = null;
        fechaFormateada = null;
        comboBCursos.setValue(null);
        comboBCursos.setPromptText("Seleccione un curso...");
        datePAsignacion.setValue(null);
        tablaAsignaciones.setItems(null);
        tablaAsignaciones.setPlaceholder(new Label(pholderTablaInicio));
        graficoSolvencia.setData(FXCollections.observableArrayList());

//        System.out.println(cursoSeleccionado);
//        System.out.println(fechaFormateada);
    }

    public void initialize(){
        comboBCursos.setItems(listaCursos);

        colCarnet.setCellValueFactory(new PropertyValueFactory<>("carnet"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colFechaInsc.setCellValueFactory(new PropertyValueFactory<>("fechaAsignacion"));
        colSolvencia.setCellValueFactory(new PropertyValueFactory<>("solvencia"));
        tablaAsignaciones.setItems(null);
        tablaAsignaciones.setPlaceholder(new Label(pholderTablaInicio));

        cursoSeleccionado = null;
        fechaFormateada = null;

         //Añadir listener al ComboBox
        comboBCursos.setOnAction(event -> {
            cursoSeleccionado = (String) comboBCursos.getValue();
            if (cursoSeleccionado != null ) {

                llenarTablaAsignados(cursoSeleccionado, fechaFormateada);
            }
        });

        //Añadir listener al DatePicker
        datePAsignacion.setOnAction(actionEvent -> {
            if(datePAsignacion.getValue() != null){
                fechaFormateada = app.formatearFecha(datePAsignacion.getValue());
                if (fechaFormateada != null )
                {
                    llenarTablaAsignados(cursoSeleccionado, fechaFormateada);
                }
            }
        });
    }
}
