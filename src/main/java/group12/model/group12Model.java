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


public class group12Model
{
    private CategoryNode rootCategory;
    private CategoryNode currentNode;

    private Resource currentResource;

    public static void main(String[] args)
    {
        group12Model model = new group12Model("andrew");
        model.createCategory("cooking", "how I cook");
        model.createResource("WEbsite", "descri[tipn", "https://www.nytimes.com/2022/11/06/dining/what-to-cook-this-week.html",ResourceType.ARTICLE);
        Resource resource = model.getCurrentResource();
        resource.displayResource();


    }
    public group12Model(String name)
    {
        this.rootCategory = new CategoryNode(name,"");
        this.currentNode = rootCategory;
    }

    public void switchNode(String name)
    {
        currentNode = this.currentNode.getNextCategory(name);
    }

    public void createCategory(String name, String description)
    {
        this.currentNode.addCategory(name,description);
    }

    public void createResource(String name, String description, String URL,ResourceType type)
    {
        Resource newResource = new Resource(name,description,URL,type);
        newResource = this.currentNode.addResource(newResource);
        this.currentResource = newResource;
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