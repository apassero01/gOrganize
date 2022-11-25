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
 *
 * *****************************************/
package group12.controller;

import group12.ViewSwitcher;
import group12.model.CategoryNode;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javax.swing.text.View;
import java.io.IOException;

public class AddCategoryController implements Controller
{
    @FXML
    Button backButton;

    @FXML
    Button continueButton;

    @FXML
    TextArea nameArea;

    @FXML
    TextArea descriptionArea;

    group12Model model;

    ViewSwitcher viewSwitcher;


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

    public void createCategory()
    {
        CategoryNode currentCategory = this.model.getCurrentNode();
        currentCategory.addCategory(this.nameArea.getText(),this.descriptionArea.getText());
        try
        {
            this.viewSwitcher.switchTo("CategoryView.fxml",this.continueButton,this.model);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}