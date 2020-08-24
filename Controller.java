package GUICalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    Label label;
    double result;
    private double number1;
    private double number2;
    private String operator = "";
    private boolean flag = true;
    private boolean operationWithResult = false;
    Operations operations = new Operations();

    @FXML
    public void numberButtonControl(ActionEvent event) {
        if(flag) {
            label.setText("");
            flag = false;
        }
        String getBtnTxt = ((Button) event.getSource()).getText();
        label.setText(label.getText() + getBtnTxt);
        operationWithResult = false;
    }

    @FXML
    public void operatorButtonControl(ActionEvent event) {
        String getBtnTxt = ((Button)event.getSource()).getText();
        if(!getBtnTxt.equals("=")) {
            if(!operator.isEmpty()) {
                number2 = Double.parseDouble(label.getText());
                number1 = operations.calc(number1,number2,operator);
                operator = getBtnTxt;
                label.setText("");
            }
            if(operationWithResult) {
                number1 = result;
            } else {
                number1 = Double.parseDouble(label.getText());
            }
            operator = getBtnTxt;
            label.setText("");
        } else {
            if(operator.isEmpty()) return;
            number2 = Double.parseDouble(label.getText());
            result = operations.calc(number1,number2,operator);
            label.setText(String.valueOf(result));
            operator = "";
            flag = true;
            operationWithResult = true;
        }
    }

    @FXML
    public void modulusOperation() {
        number1 = Double.parseDouble(label.getText());
        label.setText("");
        result = number1/100;
        label.setText(label.getText() + result);
        operationWithResult = true;
    }

    @FXML
    public void clearEverything () {
        operator = "";
        flag = true;
        label.setText("");
        operationWithResult = false;
    }

    @FXML
    public void backSpace () {
        StringBuilder stringBuilderLabel = new StringBuilder(label.getText());
        int length = (stringBuilderLabel.length() - 1);
        stringBuilderLabel = stringBuilderLabel.deleteCharAt(length);
        label.setText((stringBuilderLabel.toString()));
    }
}
