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

 *

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

public class ViewSwitcher {


    private Scene scene;


    public void switchTo(String fileName, Button btn, group12Model model) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
        Parent root = loader.load();
        this.scene = new Scene(root);

        Controller controller = loader.getController();
        controller.setModel(model);
        controller.initController();
        Stage stage = (Stage) btn.getScene().getWindow();

        Main.loadScene(stage, scene);

    }
    public Scene getScene() {
        return this.scene;
    }



}
