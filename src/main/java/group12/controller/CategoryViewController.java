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
import group12.model.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import group12.model.group12Model;

import java.awt.*;
import java.io.IOException;
import java.util.TreeMap;

public class CategoryViewController implements Controller{

    @FXML
    public Button backButton;

    @FXML
    public Button addCategoryButton;

    @FXML
    public Button addResourceButton;

    @FXML
    public HBox hbox;

    @FXML
    public VBox vbox;

    @FXML
    public MenuItem menuItem;

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
        this.hbox.setSpacing(50);
        this.hbox.setAlignment(Pos.CENTER);
        viewSwitcher = new ViewSwitcher();
        initSubCategories();
        initResources();
        this.addCategoryButton.setOnAction(event -> {
            try
            {
                this.viewSwitcher.switchTo("AddCategoryView.fxml",this.addCategoryButton,this.model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
    }

    private void initSubCategories()
    {
        CategoryNode currentNode = this.model.getCurrentNode();
        TreeMap<String,CategoryNode> childrenCategories = currentNode.getChildrenCategories();
        for (String key: childrenCategories.keySet())
        {
            Button btn = buttonFactory(key,"CategoryView.fxml");
            btn.setAlignment(Pos.CENTER);
            btn.setPrefHeight(75);
            btn.setPrefWidth(100);
            this.hbox.getChildren().add(btn);
        }
    }

    public void initResources()
    {
        CategoryNode currentNode = this.model.getCurrentNode();
        TreeMap<String, Resource> childrenResources = currentNode.getResources();
        for (String key: childrenResources.keySet())
        {
            this.vbox.getChildren().add(buttonFactory(key,"WebResourceView.fxml"));
        }
    }

    public Button buttonFactory(String name,String view)
    {
        Button curButton = new Button(name);

        curButton.setOnAction(event -> {
            try
            {
                if (view.equals("CategoryView.fxml"))
                {
                    this.model.switchNode(name);
                }
                else
                {
                    this.model.selectResource(name);
                }
                this.viewSwitcher.switchTo(view,curButton,model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
        return curButton;
    }

    public void addWebRosource(javafx.event.ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddWebResource.fxml",backButton,this.model);
    }


    public void addDefaultResource(ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddDefaultResource.fxml",backButton,this.model);
    }
}
