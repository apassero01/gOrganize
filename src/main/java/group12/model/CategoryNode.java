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

import java.io.Serializable;
import java.util.TreeMap;

public class CategoryNode implements Serializable
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

    public void addResource(Resource resource)
    {
        this.resources.put(resource.getName(),resource);
    }
    public void addDescription(String description)
    {
        this.desciption = description;
    }

    public CategoryNode getNextCategory(String name)
    {
        return childrenCategories.get(name);
    }

    @Override
    public String toString()
    {
        return "CategoryNode{" +
                "name='" + name + '\'' +
                ", childrenCategories=" + childrenCategories +
                ", resources=" + resources +
                '}';
    }
}