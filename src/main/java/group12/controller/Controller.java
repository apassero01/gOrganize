package group12.controller;

import group12.model.group12Model;

/**
 * Interface for all Controllers to implement
 * Before a new view can be displayed each controller needs to be assigned a group12Model
 * and be initialized to display the current state of the model
 */
public interface Controller
{
    /**
     * Method for assigning model to controller
     * @param model
     */
    public void setModel(group12Model model);

    /**
     * Method for initializing current controller to disply current state of model
     */
    public void initController();
}
