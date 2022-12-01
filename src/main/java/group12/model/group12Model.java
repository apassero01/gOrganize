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
 *
 * *****************************************/
package group12.model;


import java.io.Serializable;

public class group12Model implements Serializable
{
    private CategoryNode rootCategory;
    private CategoryNode currentNode;

    private static ManageData manageData;
    private Resource currentResource;

    public group12Model(String name)
    {
        this.rootCategory = new CategoryNode(name,"",null);
        this.currentNode = rootCategory;
    }

    public void switchNode(String name)
    {
        currentNode = this.currentNode.getNextCategory(name);
    }

    public ResourceType selectResource(String name)
    {
        this.currentResource = this.currentNode.getResources().get(name);
        return this.currentResource.getType();
    }

    public void createCategory(String name, String description)
    {
        this.currentNode.addCategory(name,description);
        saveData();
    }

    public void saveData()
    {
        manageData = new ManageData();
        manageData.writeData(this);
    }

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

    public void addResourceText(String string)
    {

        this.currentResource.setNotesText(string);
        saveData();
    }

    public void switchToParent()
    {
        this.currentNode = this.currentNode.getParent();
    }

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
