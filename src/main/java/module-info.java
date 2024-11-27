module edu.actividad1.poo2.proyectofinal_poo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.actividad1.poo2.proyectofinal_poo2 to javafx.fxml;
    exports edu.actividad1.poo2.proyectofinal_poo2;
    exports edu.actividad1.poo2.proyectofinal_poo2.controladores;
    opens edu.actividad1.poo2.proyectofinal_poo2.controladores to javafx.fxml;
    opens edu.actividad1.poo2.proyectofinal_poo2.modelos;
}