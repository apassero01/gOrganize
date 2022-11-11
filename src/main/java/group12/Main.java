package group12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        primaryStage.setTitle("App Name");
        var currentScene = new Scene(root,600,500);


        primaryStage.setScene(currentScene);
        primaryStage.show();


    }

    public static void main(String[] args) { launch(args); }



}
