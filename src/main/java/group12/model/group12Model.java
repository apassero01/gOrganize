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

    public static void main(String[] args)
    {
        ManageData manageData = new ManageData();
        group12Model model = new group12Model("andrew");
        model.createCategory("cooking", "how I cook");
        model.switchNode("cooking");
        model.createResource("WEbsite", "descri[tipn", "https://www.nytimes.com/2022/11/06/dining/what-to-cook-this-week.html",ResourceType.ARTICLE);
        System.out.println(model.getCurrentNode());
        manageData.writeData(model);

        group12Model model2 = (group12Model) manageData.readData();
        System.out.println(model2.getCurrentNode());


    }
    public group12Model(String name)
    {
        this.rootCategory = new CategoryNode(name,"",null);
        this.currentNode = rootCategory;
    }

    public void switchNode(String name)
    {
        currentNode = this.currentNode.getNextCategory(name);
    }

    public void selectResource(String name){this.currentResource = this.currentNode.getResources().get(name);}

    public void createCategory(String name, String description)
    {
        manageData = new ManageData();
        this.currentNode.addCategory(name,description);
        manageData.writeData(this);
    }

    public void createResource(String name, String description, String locator,ResourceType type)
    {
        manageData = new ManageData();
        Resource resource;
        switch (type)
        {
            case ARTICLE:
                ArticleResource articleResource = new ArticleResource(name,description,locator);
                resource = articleResource;
                break;
            default:
                resource = new Resource(name,description,locator,ResourceType.NONE);
                break;
        }
        this.currentNode.addResource(resource);
        this.currentResource = resource;
        manageData.writeData(this);
    }

    public void addResourceText(String string)
    {
        this.currentResource.setNotesText(string);
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
