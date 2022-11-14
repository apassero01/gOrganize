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


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {


    private Scene scene;


    public void switchTo(String fileName) throws IOException {
        Parent root = FXMLLoader.load(ViewSwitcher.class.getResource(fileName));
        this.scene = new Scene(root);

    }
    public Scene getScene() {
        return this.scene;
    }



}
