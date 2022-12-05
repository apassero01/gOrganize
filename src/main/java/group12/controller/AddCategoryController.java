/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/25/22* Time: 4:30 PM
 *
 * Project: csci205_final_project
 * Package: group12.controller
 * Class: AddCategoryController
 *
 * Description:
 * View for adding a new category
 * *****************************************/
package group12.controller;

import group12.ViewSwitcher;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Controller for AddCategory View
 */
public class AddCategoryController implements Controller
{
    /** backButton of current view  */
    @FXML
    Button backButton;

    /** continue button to create the new category */
    @FXML
    Button continueButton;

    /** TextArea for user input of name of new category  */
    @FXML
    TextArea nameArea;

    /** TextArea for the description of the new category */
    @FXML
    TextArea descriptionArea;

    /** Current model  */
    group12Model model;

    /** ViewSwitcher object for switching to new view */
    ViewSwitcher viewSwitcher;


    /**
     * @Overrides interface method for setting current model to controller
     * @param model
     */
    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
        this.viewSwitcher = new ViewSwitcher();
    }

    /**
     * @Overrides interface method for initializing controller
     */
    @Override
    public void initController()
    {
        this.continueButton.setOnAction(event -> {
            createCategory();
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
     * Method to create new Category
     */
    public void createCategory()
    {

        this.model.createCategory(this.nameArea.getText(),this.descriptionArea.getText());
        try
        {
            this.viewSwitcher.switchTo("CategoryView.fxml",this.continueButton,this.model);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}