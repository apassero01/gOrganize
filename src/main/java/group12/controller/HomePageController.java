/* *****************************************

 * CSCI205 - Software Engineering and Design

 * Fall 2022

 * Instructor: Prof. Brian King

 *

 * Name: Patrick Quinlivan

 * Section: 11:00 AM

 * Date: 11/9/22

 * Time: 11:39 AM

 *

 * Project: csci205_final_project

 * Package: group12

 * Class: AppController *

 * Description:

 *

 * ****************************************

 */

package group12.controller;

import group12.ViewSwitcher;
import group12.model.group12Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller class for homepage of application
 */
public class HomePageController implements Controller {


    /** Button for going to first category in the tree */
    @FXML
    public Button treeBtn;

    /** Label for the text displayed throughout tutorial */
    @FXML
    Label tutorialText;

    /** Button for going left in tutorial */
    @FXML
    Button leftButton;

    /** Button for going right in tutorial */
    @FXML
    Button rightButton;

    /** ImageView to display tutorial images*/
    @FXML
    ImageView imageView;

    /** List of image objects to display during tutorial */
    private ArrayList<Image> imageList;

    /** List of tutorial Strings to display with corresponding images.Same index as imageList  */
    private ArrayList<String> imageTextList;

    /** current index being displayed in tutorial slide show  */
    private int index;

    /** Current model of application */
    public group12Model model;


    @FXML
    public void onClick() throws IOException {
        ViewSwitcher viewSwitcher = new ViewSwitcher();
        model.setCurrentNode(model.getRootCategory());
        viewSwitcher.switchTo("CategoryView.fxml",treeBtn,model);
    }

    @Override
    public void setModel(group12Model model)
    {
        this.model=model;
    }

    /**
     * Override interface initController method for this controller. Creates an ArrayList
     * for images and statements to display in the tutorial on the homepage
     */
    @Override
    public void initController()
    {
        index = 0;
        this.imageList = new ArrayList<>();
        this.imageTextList = new ArrayList<>();

        this.imageList.add(new Image(("file:Screen_Shot_2022-12-05_at_7.11.42_PM.png")));

        this.imageTextList.add("Create categories for all the areas of your life you need to store information");

        this.imageList.add(new Image("file:group12/Screen_Shot_2022-12-05_at_7.12.15_PM.png"));
        this.imageTextList.add("Add sub categories to get more specific along with things to remember related to the category");

        this.imageList.add(new Image("file:group12/Screen_Shot_2022-12-05_at_7.12.42_PM.png"));
        this.imageTextList.add("Add web resources linked to a web address for easy access to the website along with your notes");

        this.imageList.add(new Image("file:group12/Screen_Shot_2022-12-05_at_7.15.36_PM.png"));
        this.imageTextList.add("Or just store simple text to make sure you remember");


        this.imageView.setPreserveRatio(false);

        this.imageView.setImage(imageList.get(index));
        this.tutorialText.setText(imageTextList.get(index));

        initButtons();



    }

    /**
     * Initialize slide show buttons
     */
    private void initButtons()
    {
        this.leftButton.setOnAction(event -> {
            if (index == 0)
            {

            }
            else
            {
                index--;
                this.imageView.setImage(imageList.get(index));
                this.tutorialText.setText(imageTextList.get(index));
            }
        });
        this.rightButton.setOnAction(event -> {
            if (index == imageList.size()-1)
            {

            }
            else
            {
                index++;
                this.imageView.setImage(imageList.get(index));
                this.tutorialText.setText(imageTextList.get(index));
            }
        });
    }
}
