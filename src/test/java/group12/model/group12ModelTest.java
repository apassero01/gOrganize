package group12.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class group12ModelTest
{
    private group12Model group12Model;

    private CategoryNode categoryNode;

    private Resource resource;
    @BeforeEach
    void setUp()
    {
        this.group12Model = new group12Model("Name");
        this.group12Model.createCategory("Category2","description");
        this.group12Model.createResource("resource1","desc","",ResourceType.DEFAULT);

    }

    /**
     * Testing models switch node method. In setUp() method of test,
     * "Category2" was added as a child category to the model. Calling the switchNode() function with that name
     * should change the models currentNode to a CategoryNode with name "Category2"
     */
    @Test
    void switchNode()
    {
        assertEquals(group12Model.getCurrentNode().getName(),"Name");
        group12Model.switchNode("Category2");
        assertEquals(group12Model.getCurrentNode().getName(),"Category2");
    }

    /**
     * Unit test for createCategory method of model. After setUp(), size of child category should be 1,
     * this test adds a new category and verifies the child categories size increases two 2 and that we can
     * retrieve the newly created CategoryNode and it has the correct properties
     */
    @Test
    void createCategory()
    {
        assertEquals(group12Model.getCurrentNode().getChildrenCategories().size(), 1);

        String name = "newCategory";
        String desc = "description";
        group12Model.createCategory(name,desc);

        assertEquals(group12Model.getCurrentNode().getChildrenCategories().size(), 2);

        CategoryNode newCategory = group12Model.getRootCategory().getNextCategory(name);

        assertEquals(newCategory.getName(),name);
        assertEquals(newCategory.getDesciption(),desc);
    }


    /**
     * Unit test to verify a resource is properly created and added to the models current Category.
     */
    @Test
    void createResource()
    {
        String name = "newResource";
        String desc = "desc";
        ResourceType type = ResourceType.DEFAULT;
        assertEquals(group12Model.getCurrentNode().getResources().size(),1);
        group12Model.createResource(name,desc,"",type);

        assertEquals(group12Model.getCurrentNode().getResources().size(),2);
        Resource resource = group12Model.getCurrentNode().getResources().get(name);
        assertEquals(resource.getName(), name);
        assertEquals(resource.getDescription(),desc);
        assertEquals(resource.getType(),type);
    }

    /**
     * Test to verify adding user input text to a resource works correctly.
     * A resource is already added in setUp() so that resource will be used for test.
     */
    @Test
    void addResourceText()
    {
        assertEquals(group12Model.getCurrentResource().getNotesText(), "");
        String testString = "This string will verify if text is properly added to the resource via the model";
        group12Model.addResourceText(testString);

        Resource resource = group12Model.getCurrentResource();
        assertEquals(resource.getNotesText(),testString);

    }

    @Test
    /**
     * Test to verify switchingToParent function works properly. In setUp() the first category created is
     * called "Name" and has a child category Category2. This test will set the currentCategory of the model to
     * Category2 then verify the switchToParent() method changes the currentCategory to a CategoryNode with
     * name "Name"
     */
    void switchToParent()
    {
        assertEquals(group12Model.getCurrentNode().getName(), "Name");
        group12Model.switchNode("Category2");
        CategoryNode tempCategory = group12Model.getCurrentNode();
        assertEquals(tempCategory.getName(),"Category2");
        group12Model.switchToParent();
        assertEquals(group12Model.getCurrentNode().getName(),"Name");
    }
}