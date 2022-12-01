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

public class DefaultResourceController extends ResourceController
{

    @FXML
    TextArea textArea;

    @FXML
    Button saveButton;
    @FXML
    Button backButton;

    @FXML
    Label titleLabel;

    @FXML
    Label descriptionLabel;

    private static ViewSwitcher viewSwitcher;

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