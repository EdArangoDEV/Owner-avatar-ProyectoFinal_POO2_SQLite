package edu.actividad1.poo2.proyectofinal_poo2.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conexion = null;
    private  String url = "jdbc:sqlite:AsignacionesCurso.db";

    public Conexion(){
        if (conexion == null){
            try {
                // se utiliza en Java para cargar el controlador JDBC específico para SQLite.
                Class.forName("org.sqlite.JDBC");
                conexion = (Connection) DriverManager.getConnection(this.url);

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  Connection getConexion(){
        return  this.conexion;
    }

    public void closeConexion(){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
