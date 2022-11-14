/* *****************************************

 * CSCI205 - Software Engineering and Design

 * Fall 2022

 * Instructor: Prof. Brian King

 *

 * Name: Patrick Quinlivan

 * Section: 11:00 AM

 * Date: 11/14/22

 * Time: 3:14 PM

 *

 * Project: csci205_final_project

 * Package: group12.controller

 * Class: CategoryViewController *

 * Description:

 *

 * ****************************************

 */

package group12.controller;


import group12.Main;
import group12.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryViewController {

    @FXML
    public Button backButton;

    @FXML
    public void goBack(MouseEvent event) {
        ViewSwitcher viewSwitcher = new ViewSwitcher();
        try {
            viewSwitcher.switchTo("homePage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene newScene = viewSwitcher.getScene();

        Stage stage = (Stage) backButton.getScene().getWindow();

        Main.loadScene(stage, newScene);

    }

}
