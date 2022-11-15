/* *****************************************

 * CSCI205 - Software Engineering and Design

 * Fall 2022

 * Instructor: Prof. Brian King

 *

 * Name: Patrick Quinlivan

 * Section: 11:00 AM

 * Date: 11/14/22

 * Time: 3:14 PM

 *

 * Project: csci205_final_project

 * Package: group12.controller

 * Class: CategoryViewController *

 * Description:

 *

 * ****************************************

 */

package group12.controller;

import group12.ViewSwitcher;
import group12.model.CategoryNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import group12.model.group12Model;

import java.io.IOException;
import java.util.TreeMap;

public class CategoryViewController implements Controller{

    @FXML
    public Button backButton;

    @FXML
    public HBox hbox;

    @FXML
    public VBox vbox;

    private group12Model model;

    private ViewSwitcher viewSwitcher;

    @FXML
    public void goBack(MouseEvent event) throws IOException
    {
        if (this.model.getCurrentNode() == this.model.getRootCategory())
        {
            viewSwitcher.switchTo("homePage.fxml",backButton,this.model);
        }
        else
        {
            this.model.switchToParent();
            viewSwitcher.switchTo("CategoryView.fxml",backButton,this.model);
        }
    }

    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
    }

    @Override
    public void initController()
    {
        viewSwitcher = new ViewSwitcher();
        CategoryNode currentNode = this.model.getCurrentNode();
        TreeMap<String,CategoryNode> childrenCategories = currentNode.getChildrenCategories();
        for (String key: childrenCategories.keySet())
        {
            this.hbox.getChildren().add(buttonFactory(key,"CategoryView.fxml"));
        }
    }

    public Button buttonFactory(String name,String view)
    {
        Button curButton = new Button(name);

        curButton.setOnAction(event -> {
            try
            {
                this.model.switchNode(name);
                this.viewSwitcher.switchTo(view,curButton,model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
        return curButton;
    }
}
