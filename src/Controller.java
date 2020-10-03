package GUICalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    Label label;
    @FXML
    Label operatorLabel;
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
        operatorLabel.setText(getBtnTxt);
        if(!getBtnTxt.equals("=")) {
            if(!operator.isEmpty()) {
                number2 = Double.parseDouble(label.getText());
                number1 = operations.calc(number1,number2,operator);
                operator = getBtnTxt;
                label.setText("" + number1);
                flag = true;
            }
            else if(operationWithResult) {
                number1 = result;
            } else {
                number1 = Double.parseDouble(label.getText());
            }
            operator = getBtnTxt;
            flag = true;
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
    public void modulusOperation(ActionEvent event) {
        number1 = Double.parseDouble(label.getText());
        operatorLabel.setText(((Button)event.getSource()).getText());
        result = number1/100;
        label.setText("" + result);
        operationWithResult = true;
    }

    @FXML
    public void clearEverything () {
        operator = "";
        flag = true;
        label.setText("");
        operationWithResult = false;
        operatorLabel.setText("");
    }

    @FXML
    public void backSpace () {
        StringBuilder stringBuilderLabel = new StringBuilder(label.getText());
        int length = (stringBuilderLabel.length() - 1);
        stringBuilderLabel = stringBuilderLabel.deleteCharAt(length);
        label.setText((stringBuilderLabel.toString()));
    }
}
