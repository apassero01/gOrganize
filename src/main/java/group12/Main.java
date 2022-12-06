package group12;

import group12.controller.*;
import group12.model.ManageData;
import group12.model.ResourceType;
import group12.model.group12Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.File;

/**
 * Main Class for starting application
 */
public class  Main extends Application
{

    /** ManageData object to retrieve data */
    public static ManageData manageData;

    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));


        Parent root = loader.load();
        var scene = new Scene(root);
        HomePageController homePageController = loader.getController();
        group12Model model = initializeModel();
        homePageController.setModel(model);
        homePageController.initController();

        primaryStage.setTitle("gOrganize");

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

    /**
     * Method for initializing model object for application
     * if data file exists, pull data if not create new model and write data
     * @return - group12Model model of application
     */
    public static group12Model initializeModel()
    {
        group12Model model;
        manageData = new ManageData();
        File file = new File("SerializedModel.bin");
        if (file.exists())
        {
            model = (group12Model) manageData.readData();
        }
        else
        {
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setTitle("Enter your Name");
            inputDialog.setHeaderText("Enter your name");
            inputDialog.showAndWait();

            model = new group12Model(inputDialog.getEditor().getText()+"'s Resource Tree");
            model.saveData();
        }

        return model;
    }

}


