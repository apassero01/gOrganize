/* *****************************************

 * CSCI205 - Software Engineering and Design

 * Fall 2022

 * Instructor: Prof. Brian King

 *

 * Name: Patrick Quinlivan

 * Section: 11:00 AM

 * Date: 11/9/22

 * Time: 11:39 AM

 *

 * Project: csci205_final_project

 * Package: group12

 * Class: AppController *

 * Description:

 *

 * ****************************************

 */

package group12.controller;


import group12.Main;
import group12.ViewSwitcher;
import group12.model.group12Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class HomePageController {


    private group12Model theModel;
    @FXML
    public Button treeBtn;

//    public HomePageController(){
//        //this.theModel = theModel;
//        this.viewSwitcher = new ViewSwitcher();
//    }


    @FXML
    public void onClick() throws IOException {
        ViewSwitcher viewSwitcher = new ViewSwitcher();
        viewSwitcher.switchTo("Categoryview.fxml");
        Scene newScene = viewSwitcher.getScene();

        Stage stage = (Stage) treeBtn.getScene().getWindow();

        Main.loadScene(stage, newScene);
    }



}