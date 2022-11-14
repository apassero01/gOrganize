package group12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class  Main extends Application
{


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
       // System.out.println("load file");
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        //System.out.println("loaded as loader");

        var scene = new Scene(root,600,300);
        //Scene root = loader.load();
        //System.out.println("loaded as scene");

        primaryStage.setTitle("App Name");

        //loadScene(primaryStage,currentScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }


    public static void loadScene(Stage stage, Scene scene){
        try{
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}


