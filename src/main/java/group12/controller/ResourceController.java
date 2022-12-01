/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/30/22* Time: 7:46 PM
 *
 * Project: csci205_final_project
 * Package: group12.controller
 * Class: ResourceController
 *
 * Description:
 *
 * *****************************************/
package group12.controller;

import group12.model.Resource;
import group12.model.group12Model;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;



public abstract class ResourceController implements Controller
{

    protected TextArea parentTextArea;

    protected Button parentSaveButton;

    protected Label parentTitleLabel;

    protected Label parentDescriptionLabel;

    protected Resource resource;

    protected group12Model model;

    protected void initButtons()
    {
        this.parentSaveButton.setOnAction(actionEvent -> {
            this.model.addResourceText(this.parentTextArea.getText());
            updateTextDisplay();
        });

        this.parentTitleLabel.setText(this.resource.getName());
        this.parentDescriptionLabel.setText(this.resource.getDescription());

    }

    protected void updateTextDisplay()
    {
        Resource resource = this.model.getCurrentResource();
        this.parentTextArea.setText(resource.getNotesText());
    }

    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
        this.resource = this.model.getCurrentResource();
    }

}