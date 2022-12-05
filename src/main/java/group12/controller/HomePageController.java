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

import group12.ViewSwitcher;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Controller class for homepage of application
 */
public class HomePageController implements Controller {


    /** Button for going to first category in the tree */
    @FXML
    public Button treeBtn;

    /** Label for name of application */
    @FXML
    public Label label1;

    /** Current model of application */
    public group12Model model;


    @FXML
    public void onClick() throws IOException {
        ViewSwitcher viewSwitcher = new ViewSwitcher();
        model.setCurrentNode(model.getRootCategory());
        viewSwitcher.switchTo("CategoryView.fxml",treeBtn,model);
    }

    @Override
    public void setModel(group12Model model)
    {
        this.model=model;
    }

    /**
     * No initialization needed
     */
    @Override
    public void initController()
    {

    }
}
