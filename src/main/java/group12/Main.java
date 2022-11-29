package group12;

import group12.controller.*;
import group12.model.ManageData;
import group12.model.ResourceType;
import group12.model.group12Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class  Main extends Application
{

    public static ManageData manageData;

    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
       // System.out.println("load file");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));

        //System.out.println("loaded as loader");

        Parent root = loader.load();
        var scene = new Scene(root,600,300);
        HomePageController homePageController = loader.getController();
        group12Model model = initializeModel();
        model.createResource("test", "Desci","https://www.youtube.com/watch?v=c0UeuHYWp3Q",ResourceType.NONE);
        homePageController.setModel(model);
        //Scene root = loader.load();
        //System.out.println("loaded as scene");

        primaryStage.setTitle("App Name");

        //loadScene(primaryStage,currentScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}


    public static void loadScene(Stage stage, Scene scene){
        try{
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static group12Model initializeModel()
    {
        group12Model model;
        manageData = new ManageData();
        File file = new File("categories.bin");
        if (file.exists())
        {
            model = (group12Model) manageData.readData();
        }
        else
        {
            model = new group12Model("test");
        }

        return model;
    }
    public static group12Model testModel()
    {
        group12Model model = new group12Model("Andrew");
        model.createCategory("Loser","loser");
        model.createCategory("loser2","loser2");
        model.switchNode("loser2");
        model.createResource("website","","https://aiecode.com/dashboard/54", ResourceType.NONE);
        model.createCategory("loserInsideOfLoser","");
        model.switchToParent();
        return model;
    }

}


