module com.example.ejcalculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejcalculadora to javafx.fxml;
    exports com.example.ejcalculadora;
}