package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.Cursos;
import edu.actividad1.poo2.proyectofinal_poo2.modelos.PruebaAsignacion;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;


public class AsignacionController {

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegresar;

    @FXML
    private CheckBox checkBPagar;

    @FXML
    private Label lbAsignaciones;

    @FXML
    private Label lbAsignaciones1;

    @FXML
    private Label lbCVC;

    @FXML
    private Label lbCarnet;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbCursosA;

    @FXML
    private Label lbCursosD;

    @FXML
    private Label lbDireccion;

    @FXML
    private Label lbExpiracionT;

    @FXML
    private Label lbNTarjeta;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbPagoCursos;

    @FXML
    private Label lbTel;

    @FXML
    private Label lbTitular;

    @FXML
    private ListView<?> listCursos;

    public ObservableList listaCursos = Cursos.listaCursos.listaCursos;

    @FXML
    private ListView<String> listAsignados;

    public ObservableList<String> listaAsignados = FXCollections.observableArrayList();
//    public ObservableList listaAsignados = this.app.listaAsignados;

    @FXML
    private TextField txtFieldCorreo;

    @FXML
    private TextField txtFielNTarjeta;

    @FXML
    private TextField txtFieldCVC;

    @FXML
    private TextField txtFieldCarnet;

    @FXML
    private TextField txtFieldDireccion;

    @FXML
    private TextField txtFieldExpiracionT;

    @FXML
    private TextField txtFieldNombre;

    @FXML
    private TextField txtFieldTel;

    @FXML
    private TextField txtFieldTitular;


    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public void setMain(Application main){
        this.app = main;
    }

    ValidacionTextFields vtxtF = new ValidacionTextFields();

    @FXML
    void clicAsignar(ActionEvent event) {
        if(datos && !btnAsignar.isDisable())
        {
            String txtpago = "No realizo pago";
            String fechaAsignacion = app.formatearFecha(LocalDate.now());
            String solvecnia = "no";
            if(pago)
            {
                txtpago = "Realizo el pago";
                System.out.println("Se asgino el estudiante: " + txtFieldNombre.getText() + " el dia " + fechaAsignacion + " y " + txtpago);
                solvecnia = "si";
            }
            else {
                System.out.println("Se asgino el estudiante: " + txtFieldNombre.getText() + " el dia " + fechaAsignacion + " y " + txtpago);
            }
            asignacionEstudiante(solvecnia);
            limpiarDatos();
        }
        else{
            System.out.println("Debe llenar todos los campos");
        }
    }


    @FXML
    void clicCancelar(ActionEvent event) {
        limpiarDatos();
        validarDatosEstudiante();
    }

    @FXML
    void clicRegresar(ActionEvent event) {
        app.principalStage.show();
        app.asignacionesStage.hide();
    }

    boolean datos = false;
    boolean pagar = false;
    boolean pago = false;
    String curso;
    boolean validoD = false;
    boolean campoNombre = false;
    boolean campoCarnet = false;
    boolean campoTel = false;
    boolean campoDireccion = false;
    boolean campoCorreo = false;

    boolean validoP = false;
    boolean campoTarjeta = false;
    boolean campoTitular = false;
    boolean campoFExpiracion = false;
    boolean campoCVC = false;

    private void validarCamposEstudiante(Integer opcion){

        if(opcion != 0){
            switch (opcion) {
                case 1:
                    campoNombre = vtxtF.validarCampos(txtFieldNombre.getText(), 1);
                    break;
                case 2:
                    campoCarnet = vtxtF.validarCampos(txtFieldCarnet.getText(), 2);
                    break;
                case 3:
                    campoTel = vtxtF.validarCampos(txtFieldTel.getText(), 3);
                    break;
                case 4:
                    campoDireccion = vtxtF.validarCampos(txtFieldDireccion.getText(), 4);
                    break;
                case 5:
                    campoCorreo = vtxtF.validarCampos(txtFieldCorreo.getText(), 5);
                    break;
                default:
                    System.out.println("Opcion invalida!");
            }
        }

        validoD = (campoNombre && campoCarnet && campoTel && campoDireccion && campoCorreo) ? true : false;
        if (validoD)
        {
            validarDatosEstudiante();
        }
        setBotonAsignar();

    }

    private void validarCamposPago(Integer opcion){

        if(opcion != 0){
            switch (opcion) {
                case 1:
                    campoTarjeta = vtxtF.validarCampos(txtFielNTarjeta.getText(), 6);
                    break;
                case 2:
                    campoTitular = vtxtF.validarCampos(txtFieldTitular.getText(), 7);
                    break;
                case 3:
                    campoFExpiracion = vtxtF.validarCampos(txtFieldExpiracionT.getText(), 8);
                    break;
                case 4:
                    campoCVC = vtxtF.validarCampos(txtFieldCVC.getText(), 9);
                    break;
                default:
                    System.out.println("Opcion invalida!");
            }
        }

        validoP = (campoTarjeta && campoTitular && campoFExpiracion && campoCVC) ? true : false;
        if (validoP)
        {
            validarDatosPago();
        }
        setBotonAsignar();

    }


    private  void validarDatosEstudiante(){

        boolean txtFNombre = txtFieldNombre.getText() == null;
//        System.out.println(txtFNombre);
        boolean txtFCarnet = txtFieldCarnet.getText() == null;
        boolean txtFTel = txtFieldTel.getText() == null;
        boolean txtFDireccion = txtFieldDireccion.getText() == null;
        boolean txtFCorrero = txtFieldCorreo.getText() == null;
        boolean listaCursosAsig = listaCursos.isEmpty();


        pagar = (txtFNombre || txtFCarnet || txtFTel || txtFDireccion || txtFCorrero || listaCursosAsig) ? true : false;
        datos = !pagar;
        setCheckBPagar(pagar);
        setBotonAsignar();
    }

    private  void validarDatosPago(){
        boolean txtFTarjeta = txtFielNTarjeta.getText() == null;
//        System.out.println(txtFNombre);
        boolean txtFTitular = txtFieldTitular.getText() == null;
        boolean txtFExpiracion = txtFieldExpiracionT.getText() == null;
        boolean txtFCVC = txtFieldCVC.getText() == null;

        pago = (txtFTarjeta || txtFTitular || txtFExpiracion || txtFCVC) ? false : true;
        setBotonAsignar();
    }


    private void setElementosPago(boolean valor) {
        lbNTarjeta.setDisable(valor);
        txtFielNTarjeta.setDisable(valor);
        lbTitular.setDisable(valor);
        txtFieldTitular.setDisable(valor);
        lbExpiracionT.setDisable(valor);
        txtFieldExpiracionT.setDisable(valor);
        lbCVC.setDisable(valor);
        txtFieldCVC.setDisable(valor);
    }


    private void setBotonAsignar(){
        if (datos && !listaAsignados.isEmpty() && validoD) {
//            setBCancelar(false);
            if(!checkBPagar.isSelected()) {
                btnAsignar.setDisable(false);
            }
            else if (checkBPagar.isSelected() && pago && validoP) {
                btnAsignar.setDisable(false);
            }
            else {
                btnAsignar.setDisable(true);
            }
        }
        else {
            btnAsignar.setDisable(true);
            checkBPagar.setSelected(false);
            setCheckBPagar(true);
//            setBCancelar(true);
        }
    }

    private void setCheckBPagar(boolean valor){
        checkBPagar.setDisable(valor);
    }


    public void asignacionEstudiante(String solvencia){

        for (String curso : listaAsignados)
        {
            PruebaAsignacion pAsignacion = new PruebaAsignacion();
            pAsignacion.setCarnet(txtFieldCarnet.getText());
            pAsignacion.setNombre(txtFieldNombre.getText());
            pAsignacion.setCorreo(txtFieldCorreo.getText());
            pAsignacion.setFechaAsignacion(app.formatearFecha(LocalDate.now()));
            pAsignacion.setSolvencia(solvencia);
            pAsignacion.setCurso(curso);
            app.listaAsignaciones.add(pAsignacion);
        }
//        System.out.println(app.listaAsignaciones.toArray());
    }


    private void setBCancelar(boolean valor){
        btnCancelar.setDisable(valor);
    }

    private void limpiarDatos() {
        txtFieldNombre.setText(null);
        txtFieldCarnet.setText(null);
        txtFieldDireccion.setText(null);
        txtFieldTel.setText(null);
        txtFieldCorreo.setText(null);
        txtFielNTarjeta.setText(null);
        txtFieldTitular.setText(null);
        txtFieldExpiracionT.setText(null);
        txtFieldCVC.setText(null);
        listaAsignados.clear();
    }



    public void initialize(){

        limpiarDatos();

        txtFieldNombre.setText(null);
        txtFieldCarnet.setText(null);
        txtFieldDireccion.setText(null);
        txtFieldTel.setText(null);
        txtFieldCorreo.setText(null);

        // Deshabilitar boton Asingar
        setBotonAsignar();
        setCheckBPagar(true);
//        setBCancelar(true);

        // Añadir listener al CheckBox
        checkBPagar.selectedProperty().addListener((observable, antValue, nueValue) -> {
            setElementosPago(!nueValue);
            validarDatosPago();
            //System.out.println("Valor anterior: " + antValue);
            //System.out.println("Nuevo valor: " + nueValue);
        });


        txtFieldNombre.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(!nueValue  && txtFieldNombre.getText() != null){
                if(!txtFieldNombre.getText().equals("")){
//                  validarDatosEstudiante();
                    validarCamposEstudiante(1);
                } else {
//                txtFieldNombre.setText(null);
                    validarDatosEstudiante();
                }
            }

        });


        txtFieldCarnet.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldCarnet.getText() != null && !nueValue){
                if(!txtFieldCarnet.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposEstudiante(2);
                }
                else {
                    txtFieldCarnet.setText(null);
                    validarDatosEstudiante();
                }
            }
        });

        txtFieldTel.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldTel.getText() != null && !nueValue){
                if(!txtFieldTel.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposEstudiante(3);
                }
                else {
                    txtFieldTel.setText(null);
                    validarDatosEstudiante();
                }
            }
        });

        txtFieldDireccion.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldDireccion.getText() != null && !nueValue){
                if(!txtFieldDireccion.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposEstudiante(4);
                }
                else {
                    txtFieldDireccion.setText(null);
                    validarDatosEstudiante();
                }
            }
        });

        txtFieldCorreo.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldCorreo.getText() != null && !nueValue){
                if(!txtFieldCorreo.getText().equals("")){
//                            validarDatosEstudiante();
                    validarCamposEstudiante(5);
                }
                else {
                    txtFieldCorreo.setText(null);
                    validarDatosEstudiante();
                }
            }
        });

        txtFielNTarjeta.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFielNTarjeta.getText() != null && !nueValue){
                if(!txtFielNTarjeta.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposPago(1);
                }
                else {
                    txtFielNTarjeta.setText(null);
                    validarDatosPago();
                }
            }
        });

        txtFieldTitular.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldTitular.getText() != null && !nueValue){
                if(!txtFieldTitular.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposPago(2);
                }
                else {
                    txtFieldTitular.setText(null);
                    validarDatosPago();
                }
            }
        });

        txtFieldExpiracionT.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldExpiracionT.getText() != null && !nueValue){
                if(!txtFieldExpiracionT.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposPago(3);
                }
                else {
                    txtFieldExpiracionT.setText(null);
                    validarDatosPago();
                }
            }
        });

        txtFieldCVC.focusedProperty().addListener((observable, antValue, nueValue) -> {
            if(txtFieldCVC.getText() != null && !nueValue){
                if(!txtFieldCVC.getText().equals("")){
//                   validarDatosEstudiante();
                    validarCamposPago(4);
                }
                else {
                    txtFieldCVC.setText(null);
                    validarDatosPago();
                }
            }
        });

        Label placehCursos = new Label("No hay Cursos para mostrar");
        placehCursos.setId(".placeholder-label");
        Label placehAsignaciones = new Label("No hay Cursos Seleccionados");
        placehAsignaciones.setId(".placeholder-label");

        listCursos.setPlaceholder(placehCursos);
        listAsignados.setPlaceholder(placehAsignaciones);

        listCursos.setItems(listaCursos);


        listCursos.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);

        listCursos.setOnMouseClicked(event -> {
            curso = (String) listCursos.getSelectionModel().getSelectedItem();
            if(curso != null) {
                if (!listaAsignados.contains(curso)) {
//                    System.out.println("Curso seleccionado: " + curso);
                    listaAsignados.add(curso);
                    listAsignados.setItems(listaAsignados);
                } else {
//                    System.out.println("El curso ya está asignado: " + curso);
                }
                curso = null;
                listCursos.getSelectionModel().clearSelection();

                if (txtFieldNombre.getText() != null && txtFieldCarnet.getText() != null && txtFieldTel.getText() != null && txtFieldDireccion.getText() != null && txtFieldCorreo.getText() != null ) {
                    validarCamposEstudiante(0);
                }
            }
        });

        listAsignados.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);

        listAsignados.setOnMouseClicked(event -> {
            curso = (String) listAsignados.getSelectionModel().getSelectedItem();
            if (curso != null){
//                System.out.println("Curso seleccionado " + curso);
                if(listaAsignados.size() == 1)
                {
                    listaAsignados.clear();
                }
                else {
                    listaAsignados.remove(curso);
                }
                listAsignados.setItems(listaAsignados);

                curso = null;
                listAsignados.getSelectionModel().clearSelection();
                if (txtFieldNombre.getText() != null && txtFieldCarnet.getText() != null && txtFieldTel.getText() != null && txtFieldDireccion.getText() != null && txtFieldCorreo.getText() != null ) {
                    validarCamposEstudiante(0);
                }
            }
        });
    }

}