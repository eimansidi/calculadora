package com.example.ejcalculadora;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends Application {

    @FXML
    private TextField txtOp1;

    @FXML
    private TextField txtOp2;

    @FXML
    private TextField txtResultado;

    @FXML
    private RadioButton RBtSumar;

    @FXML
    private RadioButton RBtRestar;

    @FXML
    private RadioButton RBtMultiplicar;

    @FXML
    private RadioButton RBtDividir;

    @FXML
    private ToggleGroup tgOp;

    @FXML
    private Button BtnCalcular;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Calculadora en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        BtnCalcular.setOnAction(e -> realizarCalculo());
    }

    private void realizarCalculo() {
        try {
            double op1 = Double.parseDouble(txtOp1.getText());
            double op2 = Double.parseDouble(txtOp2.getText());
            double resultado = 0;

            if (RBtSumar.isSelected()) {
                resultado = op1 + op2;
            } else if (RBtRestar.isSelected()) {
                resultado = op1 - op2;
            } else if (RBtMultiplicar.isSelected()) {
                resultado = op1 * op2;
            } else if (RBtDividir.isSelected()) {
                if (op2 != 0) {
                    resultado = op1 / op2;
                } else {
                    txtResultado.setText("Error: División por 0");
                    return;
                }
            }

            txtResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException ex) {
            txtResultado.setText("Error: Entrada inválida");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
