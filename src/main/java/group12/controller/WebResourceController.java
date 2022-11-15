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

import group12.model.Resource;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;

public class WebResourceController implements Controller
{
    @FXML
    FlowPane flowPane;
    private group12Model model;

    private Resource resource;
    @Override
    public void setModel(group12Model model)
    {
        this.model = model;
    }

    @Override
    public void initController()
    {
        this.resource = this.model.getCurrentResource();
        WebView webView = new WebView();

        webView.getEngine().load(resource.getResourceURL());
        flowPane.getChildren().add(webView);
    }
}