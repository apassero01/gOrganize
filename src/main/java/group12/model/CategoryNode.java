/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/6/22* Time: 1:41 PM
 *
 * Project: csci205_final_project
 * Package: group12.model
 * Class: CategoryNode
 *
 * Description:
 *
 * *****************************************/
package group12.model;

import java.util.TreeMap;

public class CategoryNode
{
    private String name;
    private TreeMap<String, CategoryNode> childrenCategories;
    private TreeMap<String, Resource> resources;
    private String desciption;

    public CategoryNode(String name,String description)
    {
        this.name = name;
        this.childrenCategories = new TreeMap<>();
        this.resources = new TreeMap<>();
        this.desciption = description;
    }

    public void addCategory(String name,String desciption)
    {
        CategoryNode newCategory = new CategoryNode(name,desciption);
        this.childrenCategories.put(name,newCategory);
    }

    public Resource addResource(Resource resource)
    {
        ResourceType type = resource.getType();
        String name = resource.getName();
        String descroption = resource.getDescription();
        String URL = resource.getResourceURL();
        switch (type)
        {
            case ARTICLE:
                ArticleResource articleResource = new ArticleResource(name,descroption,URL);
                resource = articleResource;
                break;
            default:
                break;
        }
        this.resources.put(name,resource);
        return resource;
    }
    public void addDescription(String description)
    {
        this.desciption = description;
    }

    public CategoryNode getNextCategory(String name)
    {
        return childrenCategories.get(name);
    }

}