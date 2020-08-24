package GUICalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CalcIntrfce.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 364, 406));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
