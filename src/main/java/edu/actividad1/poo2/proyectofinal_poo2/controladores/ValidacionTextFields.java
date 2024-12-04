package edu.actividad1.poo2.proyectofinal_poo2.controladores;

import edu.actividad1.poo2.proyectofinal_poo2.Application;
import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionTextFields {


    private String expresionReg(Integer opcion){
         String expresion = "";

        switch (opcion) {
            case 1:
                // expresion nombre
                expresion = "^[a-zA-Z\\s]{5,}$";
                break;
            case 2:
                // expresion carnet
                expresion = "^\\d{7}$";
            break;
            case 3:
                // expresion tel
                expresion = "^\\d{8}$";
                break;
            case 4:
                // Direccion
                expresion = "^[a-zA-Z\\d\\s]{10,}$";
                break;
            case 5:
                // Correo
                expresion = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
                break;
            case 6:
                // Tarjeta
                expresion = "^(?:\\d{4} ?){4}$";
                break;
            case 7:
                // Titular Tarjeta
                expresion = "^[a-zA-Z\\s]{5,}$";
                break;
            case 8:
                // Fecha Exp Tarjeta
                expresion = "^(0[1-9]|1[0-2])[-/](\\d{4})$";
                break;
            case 9:
                // CVC Tarjeta
                expresion = "^\\d{3}$";
                break;
            default:
                System.out.println("Opcion invalida!");
        }

        return  expresion;
    }

    private String mensajeValidacion(Integer opcion, boolean salida){
        String mensaje = "";


        switch (opcion) {
            case 1:
                // expresion nombre
                mensaje = (salida) ? "Nombre valido!" : "Nombre invalido! debe contener solo letras con minimo de 5";
                break;
            case 2:
                // expresion carnet
                mensaje = (salida) ? "Carnet valido!" : "Carnet invalido! debe contener 7 digitos";
                break;
            case 3:
                // expresion tel
                mensaje = (salida) ? "Telefono valido" : "Telefono invalido! debe contener 8 digitos";
                break;
            case 4:
                // Direccion
                mensaje = (salida) ? "Dirección valido" : "Dirección invalido! debe tener al menos 10 caracteres";
                break;
            case 5:
                // Correo
                mensaje = (salida) ? "Correo valido" : "Correo invalido! debe ser un correo valido, por ejemplo: ejemplo123@gmail.com";
                break;
            case 6:
                // Tarjeta
                mensaje = (salida) ? "Numero de Tarjeta valido" : "Numero de Tarjeta invalido! debe tener 16 digitos.";
                break;
            case 7:
                // Titular Tarjeta
                mensaje = (salida) ? "Nombre de titular valido" : "Nombre de titular invalido! debe tener almenos 5 letras.";
                break;
            case 8:
                // Fecha Exp Tarjeta
                mensaje = (salida) ? "Fecha de expiracion de Tarjeta valido" : "Fecha de expiracion de Tarjeta invalida! debe ser mes y año: separado con - o con /.";
                break;
            case 9:
                // CVC Tarjeta
                mensaje = (salida) ? "Codigo CVC valido" : "Codigo CVC  invalido! deben ser solo 3 digitos,sin espacio.";
                break;
            default:
                System.out.println("Opcion invalida!");
        }

        return  mensaje;
    }


    public boolean validarCampos(String string, Integer opcion){
        boolean salida = true;

        String regex = expresionReg(opcion); // Expresión regular para validar correos

        Pattern pattern = Pattern.compile(regex); // Compila el regex
        Matcher matcher = pattern.matcher(string); // Crea un matcher para el email

        if(!matcher.matches()){
            salida = false;
            String texto = mensajeValidacion(opcion, salida);
//            System.out.println(texto);
            alertError(texto);
        }else {
//            String texto = mensajeValidacion(opcion, salida);
//            System.out.println(texto);
        }

        return salida;
    }


    Alert alert = new Alert(Alert.AlertType.ERROR);

    public void alertError(String texto) {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(texto);
        // Cargar el archivo CSS
//        alert.getDialogPane().getStylesheets().add(getClass().getResource("edu.actividad1.poo2.proyectofinal_poo2.Estilos.css").toExternalForm());
        alert.showAndWait();
    }

    public void alertInformation(String texto, String titulo) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText(texto);
        alert.setHeaderText(titulo);
        // Cargar el archivo CSS
//        alert.getDialogPane().getStylesheets().add(getClass().getResource("edu.actividad1.poo2.proyectofinal_poo2.Estilos.css").toExternalForm());
        alert.showAndWait();
    }


    public void alertConfirmacion(String texto, String titulo) {
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText(texto);
        alert.setHeaderText(titulo);
        // Cargar el archivo CSS
//        alert.getDialogPane().getStylesheets().add(getClass().getResource("edu.actividad1.poo2.proyectofinal_poo2.Estilos.css").toExternalForm());
        alert.showAndWait();
    }

    // Cargar el archivo CSS
    String css = this.getClass().getResource("..\\src\\main\\resources\\edu\\actividad1\\poo2\\proyectofinal_poo2").toExternalForm();


}
