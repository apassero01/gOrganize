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
 *
 */
public class AddWebResourceController implements Controller
{
    @FXML
    Button backButton;

    @FXML
    Button continueButton;

    @FXML
    TextArea nameArea;

    @FXML
    TextArea descriptionArea;
    @FXML
    TextArea URLArea;

    private group12Model model;

    private ViewSwitcher viewSwitcher;


    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
        this.viewSwitcher = new ViewSwitcher();
    }

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

    public void createResource()
    {

        this.model.createResource(this.nameArea.getText(),this.descriptionArea.getText(),this.URLArea.getText(), ResourceType.WEB);
        try
        {
            this.viewSwitcher.switchTo("CategoryView.fxml",this.continueButton,this.model);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}