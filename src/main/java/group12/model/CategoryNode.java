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
 * Class to encapsulate a category that can store resources
 * *****************************************/
package group12.model;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Class to encapsulate a category that can store resources
 */
public class CategoryNode implements Serializable
{

    /** Name of Category */
    private String name;

    /**  TreeMap containing children categories key @name */
    private TreeMap<String, CategoryNode> childrenCategories;

    /** TreeMap containing resources for category */
    private TreeMap<String, Resource> resources;

    /** Description of Category */
    private String desciption;

    /** Parent Category of category */
    private CategoryNode parent;

    /**
     * Constructor for creating new CategoryNode
     * @param name - String name of new category
     * @param description - String name of new Category
     * @param parent - CategoryNode parent (Will always be instantiated within another CategoryNde)
     */
    public CategoryNode(String name,String description,CategoryNode parent)
    {
        this.parent = parent;
        this.name = name;
        this.childrenCategories = new TreeMap<>();
        this.resources = new TreeMap<>();
        this.desciption = description;
    }

    /**
     * Method to add a new child category to this category
     * @param name - name of child category
     * @param desciption - description of child category
     */
    public void addCategory(String name,String desciption)
    {
        CategoryNode newCategory = new CategoryNode(name,desciption,this);
        this.childrenCategories.put(name,newCategory);
    }

    /**
     * Method to add a resource to this category
     * @param resource - Resource object to be added
     */
    public void addResource(Resource resource)
    {
        this.resources.put(resource.getName(),resource);
    }

    /**
     * Set description for this category
     * @param description
     */
    public void addDescription(String description)
    {
        this.desciption = description;
    }

    /**
     * Method to get category from child category. Will only be called via displayed categories
     * on GUI therefore name should ALWAYS exist in the map
     * @param name - name of category to return
     * @return CategoryNode - child category
     */
    public CategoryNode getNextCategory(String name)
    {
        return childrenCategories.get(name);
    }

    /** Below are all Getter and Setter methods and toString() */
    public TreeMap<String, CategoryNode> getChildrenCategories()
    {
        return childrenCategories;
    }

    public TreeMap<String, Resource> getResources()
    {
        return resources;
    }

    public CategoryNode getParent()
    {
        return this.parent;
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