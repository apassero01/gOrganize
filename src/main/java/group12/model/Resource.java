/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/6/22* Time: 1:55 PM
 *
 * Project: csci205_final_project
 * Package: group12.model
 * Class: Resource
 *
 * Description:
 *
 * *****************************************/
package group12.model;

public class Resource
{
    protected String name;
    protected String description;
    protected String resourceLocator;
    protected ResourceType type;
    public Resource(String name, String description, String URL,ResourceType type)
    {
        this.name = name;
        this.description = description;
        this.resourceLocator = URL;
        this.type = type;

    }

    public void displayResource()
    {
        System.out.println(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getResourceURL()
    {
        return resourceLocator;
    }

    public void setResourceURL(String resourceURL)
    {
        this.resourceLocator = resourceURL;
    }

    public ResourceType getType()
    {
        return type;
    }
}