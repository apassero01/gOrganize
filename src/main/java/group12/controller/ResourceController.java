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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResourceController implements Controller
{

    protected TextArea parentTextArea;

    protected Button parentSaveButton;

    protected group12Model model;

    protected void initButtons()
    {
        this.parentSaveButton.setOnAction(actionEvent -> {
            this.model.addResourceText(this.parentTextArea.getText());
            updateTextDisplay();
        });
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
    }

    @Override
    public void initController()
    {
    }
}