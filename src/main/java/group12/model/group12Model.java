/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/6/22* Time: 3:30 PM
 *
 * Project: csci205_final_project
 * Package: group12.model
 * Class: group12Model
 *
 * Description:
 * Model class for application
 *
 * *****************************************/
package group12.model;


import java.io.Serializable;

/**
 * Model class for application implements Serializable for storing and retrieving data.
 */
public class group12Model implements Serializable
{

    /** Root category for the tree of categories */
    private CategoryNode rootCategory;

    /** Current CategoryNode to be displayed */
    private CategoryNode currentNode;

    /** Object for storing data after changes are made */
    private static ManageData manageData;

    /** currentResource to be displayed by model */
    private Resource currentResource;

    /**
     * Constructor for the model. Creates a rootCategory for the model
     * @param name - name of the model
     */
    public group12Model(String name)
    {
        this.rootCategory = new CategoryNode(name,"",null);
        this.currentNode = rootCategory;
    }

    /**
     * Method to switch currentNode of the model to a selected one
     * @param name - name of categoryNode to switch to
     */
    public void switchNode(String name)
    {
        currentNode = this.currentNode.getNextCategory(name);
    }

    /**
     * Select resource to switch to
     * @param name - name of resource
     * @return - ResourceType type of Resource of the switched resource
     */
    public ResourceType selectResource(String name)
    {
        this.currentResource = this.currentNode.getResources().get(name);
        return this.currentResource.getType();
    }

    /**
     * Method to create a new Category for the model
     * @param name - name of new CategoryNode
     * @param description - description of new CategoryNode
     */
    public void createCategory(String name, String description)
    {
        this.currentNode.addCategory(name,description);
        saveData();
    }

    /**
     * Method to save Data using manageData object
     */
    public void saveData()
    {
        manageData = new ManageData();
        manageData.writeData(this);
    }

    /**
     * Method to create a new resource for the currentCategory in the model
     * @param name - name of resource
     * @param description - description of resource
     * @param locator - String of URL of new resource
     * @param type - ResourceType of new resource
     */
    public void createResource(String name, String description, String locator,ResourceType type)
    {
        Resource resource;
        switch (type)
        {
            case WEB:
                resource = new Resource(name,description,locator,ResourceType.WEB);
                break;
            default:
                resource = new Resource(name,description,locator,ResourceType.DEFAULT);
                break;
        }
        this.currentNode.addResource(resource);
        this.currentResource = resource;
        saveData();
    }

    /**
     * Add new text to current Resources document
     * @param string
     */

    public void addResourceText(String string)
    {

        this.currentResource.setNotesText(string);
        saveData();
    }

    /**
     * Switch to parentNode of cyrrent categoryNode
     */
    public void switchToParent()
    {
        this.currentNode = this.currentNode.getParent();
    }

    /** Getter and Setter Methods below */
    public CategoryNode getRootCategory()
    {
        return rootCategory;
    }

    public CategoryNode getCurrentNode()
    {
        return currentNode;
    }

    public Resource getCurrentResource()
    {
        return currentResource;
    }

}
