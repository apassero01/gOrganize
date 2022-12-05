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
 * Class to encapsulate a Resource to be stored for later reference
 * *****************************************/
package group12.model;

import java.io.Serializable;

/**
 * Class to encapsulate a Resource to be stored for later reference
 */
public class Resource implements Serializable
{
    /** Name of resource  */
    protected String name;

    /** Description of resource */
    protected String description;

    /** Text of user Notes of a resource  */
    protected String notesText;

    /** String of URL of resource  */
    protected String resourceLocator;

    /** type of resource */
    protected ResourceType type;

    /**
     * Constructor for new resource
     * @param name - name of resource
     * @param description - description of resource
     * @param URL - URL of resource
     * @param type - ResourceType of new resource
     */
    public Resource(String name, String description, String URL,ResourceType type)
    {
        this.name = name;
        this.description = description;
        this.resourceLocator = URL;
        this.type = type;
        this.notesText = "";

    }

    /** Getter and Setter methods below */
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

    public String getNotesText()
    {
        return notesText;
    }

    public void setNotesText(String notesText)
    {
        this.notesText = notesText;
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