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
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import java.io.IOException;


public class WebResourceController extends ResourceController
{

    @FXML
    StackPane stackpane;

    @FXML
    TextArea textArea;

    @FXML
    Button saveButton;
    @FXML
    Button backButton;

    @FXML
    Label titleLabel;

    @FXML
    Label descriptionLabel;

    private static ViewSwitcher viewSwitcher;

    private WebView webView;


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
}