/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 12/1/22* Time: 2:42 PM
 *
 * Project: csci205_final_project
 * Package: group12.controller
 * Class: AddWebResourceController
 *
 * Description:
 *
 * *****************************************/
package group12.controller;

import group12.ViewSwitcher;
import group12.model.ResourceType;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Controller class for AddDefaultResource view
 */
public class AddDefaultResourceController implements Controller
{
    /** TextArea for initial text user wants to recollect  */
    @FXML
    TextArea resourceTextArea;

    /** Back button for controller */
    @FXML
    Button backButton;

    /** Continue button for creating new resource */
    @FXML
    Button continueButton;

    /** TextArea for name of new resource  */
    @FXML
    TextArea nameArea;

    /** TextArea for description of new Resource */
    @FXML
    TextArea descriptionArea;


    /** current model for controller */
    private group12Model model;

    /** ViewSwitcher for switching to new views */
    private ViewSwitcher viewSwitcher;


    /**
     * Overrides interface setModel method
     * @param model - current group12Model of application
     */
    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
        this.viewSwitcher = new ViewSwitcher();
    }

    /**
     * Overrides interface initController method for initializing this controller
     */
    @Override
    public void initController()
    {
        this.continueButton.setOnAction(event -> {
            createResource();
        });

        this.backButton.setOnAction(event -> {
            try
            {
                this.viewSwitcher.switchTo("CategoryView.fxml",this.backButton,this.model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Method to create a new resource for the model
     */
    public void createResource()
    {

        this.model.createResource(this.nameArea.getText(),this.descriptionArea.getText(),"", ResourceType.DEFAULT);
        this.model.getCurrentResource().setNotesText(this.resourceTextArea.getText());
        try
        {
            this.viewSwitcher.switchTo("CategoryView.fxml",this.continueButton,this.model);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}