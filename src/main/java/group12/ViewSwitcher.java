/* *****************************************

 * CSCI205 - Software Engineering and Design

 * Fall 2022

 * Instructor: Prof. Brian King

 *

 * Name: Patrick Quinlivan

 * Section: 11:00 AM

 * Date: 11/10/22

 * Time: 9:49 PM

 *

 * Project: csci205_final_project

 * Package: group12

 * Class: ViewSwitcher *

 * Description:

 * Class for switching views of GUI

 * ****************************************

 */

package group12;


import group12.controller.Controller;
import group12.model.group12Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class to switch views of current display of GUI
 */
public class ViewSwitcher {

    /**
     * Method for switching current display to new view
     * @param fileName - .fxml file location of next view
     * @param btn - button that called for a new view
     * @param model - current model that exists before view is switched
     * @throws IOException - thrown if .fxml file does not exist
     */
    public void switchTo(String fileName, Button btn, group12Model model) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Controller controller = loader.getController();
        controller.setModel(model);
        controller.initController();
        Stage stage = (Stage) btn.getScene().getWindow();

        Main.loadScene(stage, scene);

    }



}
