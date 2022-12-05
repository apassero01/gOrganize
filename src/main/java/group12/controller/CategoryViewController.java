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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import group12.model.group12Model;

import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Controller class for CategoryView view
 */
public class CategoryViewController implements Controller{

    /** Back button for category view */
    @FXML
    public Button backButton;

    /** Button for adding new category */
    @FXML
    public Button addCategoryButton;

    /** Hbox of view for displaying children categories */
    @FXML
    public HBox hbox;

    /** Vbox for displaying resource of current category */
    @FXML
    public VBox vbox;


    /** current model of application */
    private group12Model model;

    /** ViewSwitcher for changing to different views */
    private ViewSwitcher viewSwitcher;

    /**
     * Overrides interface setModel method
     * @param model
     */
    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
    }

    /**
     * Overrides interface initController method for this controller
     */
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

    /**
     * Method for going back to parent category of this category
     * @param event
     * @throws IOException
     */
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

    /**
     * Initialize all childrenCategories to display
     */
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

    /**
     * Method for initializing resources to display
     */
    public void initResources()
    {
        CategoryNode currentNode = this.model.getCurrentNode();
        TreeMap<String, Resource> childrenResources = currentNode.getResources();
        for (String key: childrenResources.keySet())
        {
            this.vbox.getChildren().add(resourceButtonFactory(key));
        }
    }

    /**
     * Method for creating buttons for each resource of current category
     * @param name - name of resource
     * @return Button - button to add to view of resource
     */
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
        return curButton;
    }

    /**
     * Method for creating buttons for each child category of current category
     * @param name - name of category
     * @return Button - button of child category
     */
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
        return curButton;
    }

    /**
     * Method for adding a webResource to current category
     * @param actionEvent
     * @throws IOException
     */
    public void addWebResource(javafx.event.ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddWebResource.fxml",backButton,this.model);
    }


    /**
     * Method for adding a default resource to current category
     * @param actionEvent
     * @throws IOException
     */
    public void addDefaultResource(ActionEvent actionEvent) throws IOException {
        viewSwitcher.switchTo("AddDefaultResource.fxml",backButton,this.model);
    }
}
