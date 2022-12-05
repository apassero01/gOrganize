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
import group12.model.ResourceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import group12.model.group12Model;

import java.awt.*;
import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

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

    @FXML
    public Button deleteButton;
    /** Label for description */
    @FXML
    Label descriptionLabel;

    /** Label for title of category */
    @FXML
    Label titleLabel;

    /** Label for resources */
    @FXML
    Label resourcesLabel;

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
        this.titleLabel.setText(this.model.getCurrentNode().getName());
        this.titleLabel.setAlignment(Pos.CENTER);

        this.descriptionLabel.setText(this.model.getCurrentNode().getDesciption());
        this.descriptionLabel.setAlignment(Pos.CENTER);

        this.resourcesLabel.setText("Resources for " + this.model.getCurrentNode().getName()+ " Category:");
        this.descriptionLabel.setAlignment(Pos.CENTER);

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
            Button btn = categoryButtonFactory(key);
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
            this.vbox.getChildren().add(resourceButtonFactory(key));
        }
    }

    public Button resourceButtonFactory(String name)
    {
        Button curButton = new Button(name);
        AtomicReference<String> view = new AtomicReference<>("");
        curButton.setOnAction(event -> {
            ResourceType type = this.model.selectResource(name);
            switch (type)
            {
                case WEB:
                    view.set("WebResourceView.fxml");
                    break;
                case DEFAULT:
                    view.set("DefaultResourceView.fxml");
                    break;
                default:
                    break;
            }
            try
            {
                this.viewSwitcher.switchTo(view.get(),curButton,model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
        curButton.setPrefWidth(this.vbox.getPrefWidth());
        curButton.setAlignment(Pos.CENTER_LEFT);
        return curButton;
    }
    public Button categoryButtonFactory(String name)
    {
        Button curButton = new Button(name);

        curButton.setOnAction(event -> {
            try
            {
                this.model.switchNode(name);
                this.viewSwitcher.switchTo("CategoryView.fxml",curButton,model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });
        curButton.setWrapText(true);
        curButton.setAlignment(Pos.CENTER);
        return curButton;
    }

    public void addWebResource(javafx.event.ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddWebResource.fxml",backButton,this.model);
    }


    public void addDefaultResource(ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddDefaultResource.fxml",backButton,this.model);
    }


    public void deleteCategory(ActionEvent actionEvent) throws IOException {
        CategoryNode nodeToDelete = this.model.getCurrentNode();
        this.model.switchToParent();
        this.model.getCurrentNode().getChildrenCategories().remove(nodeToDelete.getName());
        this.model.saveData();
        viewSwitcher.switchTo("CategoryView.fxml",deleteButton,this.model);
    }
}
