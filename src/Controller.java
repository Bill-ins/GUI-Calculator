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
    boolean typo = false;

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
        typo = true;
    }

    @FXML
    public void operatorButtonControl(ActionEvent event) {
        String getBtnTxt = ((Button)event.getSource()).getText();
        operatorLabel.setText(getBtnTxt);

        if(!operator.isEmpty()) {
            if(typo){
                number2 = Double.parseDouble(label.getText());
                number1 = operations.calc(number1, number2, operator);
                label.setText("" + number1);
                typo = false;
            }
        }
        else if(operationWithResult) {
            number1 = result;
        } else {
            number1 = Double.parseDouble(label.getText());
            typo = false;
        }
        operator = getBtnTxt;
        flag = true;
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
    public void resultOperation() {
        if(operator.isEmpty()) return;
        number2 = Double.parseDouble(label.getText());
        result = operations.calc(number1,number2,operator);
        label.setText("" + result);
        operator = "";
        flag = true;
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
