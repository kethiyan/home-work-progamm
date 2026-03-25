package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller{

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";

    // Handle Numbers
    @FXML
    private void handleNumber(ActionEvent event) {
        Button btn = (Button) event.getSource();
        display.appendText(btn.getText());
    }

    // Handle Operators
    @FXML
    private void handleOperator(ActionEvent event) {
        Button btn = (Button) event.getSource();
        num1 = Double.parseDouble(display.getText());
        operator = btn.getText();
        display.clear();
    }

    // Handle Equals
    @FXML
    private void handleEquals() {
        double num2 = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 != 0 ? num1 / num2 : 0;
                break;
        }

        display.setText(String.valueOf(result));
    }

    // Clear
    @FXML
    private void handleClear() {
        display.clear();
        num1 = 0;
        operator = "";
    }
}