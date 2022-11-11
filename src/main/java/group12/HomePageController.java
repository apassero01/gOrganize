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

package group12;


import group12.model.group12Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class HomePageController {

    private group12Model theModel;
    @FXML
    public Button treeBtn;

    public HomePageController(group12Model theModel){
        this.theModel = theModel;
    }


    public void onClick() throws IOException {
        ViewSwitcher.switchTo("tree.fxml");

    }



}
