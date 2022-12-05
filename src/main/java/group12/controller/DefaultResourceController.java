/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 12/1/22* Time: 11:27 AM
 *
 * Project: csci205_final_project
 * Package: group12.controller
 * Class: DefaultResourceController
 *
 * Description:
 *
 * *****************************************/
package group12.controller;

import group12.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Controller class for a DefaultResource view
 * extends ResourceController parent class as a default resource is a resource
 */
public class DefaultResourceController extends ResourceController
{

    /** TextArea for user to store the useful information that is the default resource  */
    @FXML
    TextArea textArea;

    /** Button for sabing current state of the textArea to the resource  */
    @FXML
    Button saveButton;

    /** Button for going back to parent category */
    @FXML
    Button backButton;

    /** Label for the name of the resource */
    @FXML
    Label titleLabel;

    /** Label for the description of the resource */
    @FXML
    Label descriptionLabel;

    /** ViewSwitcher object for switching views */
    private static ViewSwitcher viewSwitcher;

    /**
     * Overrides interface init controller for initializing view to current state
     */
    @Override
    public void initController()
    {
        viewSwitcher = new ViewSwitcher();
        this.backButton.setOnAction(event -> {
            try
            {
                this.viewSwitcher.switchTo("CategoryView.fxml",this.backButton,this.model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });

        this.parentSaveButton = saveButton;
        this.parentTextArea = textArea;
        this.parentDescriptionLabel = descriptionLabel;
        this.parentTitleLabel = titleLabel;
        this.updateTextDisplay();
        this.initButtons();
    }

}