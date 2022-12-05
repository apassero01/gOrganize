/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/14/22* Time: 9:25 PM
 *
 * Project: csci205_final_project
 * Package: group12.controller
 * Class: WebResourceController
 *
 * Description:
 *
 * *****************************************/
package group12.controller;

import group12.ViewSwitcher;
import group12.model.Resource;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import java.io.IOException;


/**
 * Controller class for WebResource view
 */
public class WebResourceController extends ResourceController
{
    /** stackPane for webView object*/
    @FXML
    StackPane stackpane;

    /** Text area for user input of text */
    @FXML
    TextArea textArea;

    /** Save Button of view */
    @FXML
    Button saveButton;

    /** Back button */
    @FXML
    Button backButton;

    /** Label for title of resource */
    @FXML
    Label titleLabel;

    /** Label for the description of resource */
    @FXML
    Label descriptionLabel;

    @FXML
    Button deleteButton;

    private static ViewSwitcher viewSwitcher;

    /** WebView for displaying web resource */
    private WebView webView;


    /**
     * Overrides interface method for initializing this controller
     */
    @Override
    public void initController()
    {
        viewSwitcher = new ViewSwitcher();
        createWebView();
        this.backButton.setOnAction(event -> {
            try
            {
                webView.getEngine().load(null);
                this.viewSwitcher.switchTo("CategoryView.fxml",this.backButton,this.model);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        });

        this.parentSaveButton = saveButton;
        this.parentTextArea = textArea;
        this.parentTitleLabel = titleLabel;
        this.parentDescriptionLabel = descriptionLabel;
        this.updateTextDisplay();
        this.initButtons();

    }

    /**
     * Method for creating webView to display web resourcce
     */
    private void createWebView()
    {
        webView = new WebView();
        webView.minWidth(stackpane.getWidth());
        webView.prefWidth(stackpane.getWidth());
        webView.prefHeight(stackpane.getHeight());
        webView.prefHeight(stackpane.getHeight());

        webView.getEngine().load(resource.getResourceURL());
        stackpane.getChildren().add(webView);
    }
    @FXML
    public void deleteResource(MouseEvent mouseEvent) throws IOException{
        //Remove node from Tree
        Resource resourceToDelete = this.model.getCurrentResource();
        this.model.getCurrentNode().getResources().remove(resourceToDelete);

        //Change Scene
        viewSwitcher.switchTo("CategoryView.FXML",deleteButton,this.model);

    }


}