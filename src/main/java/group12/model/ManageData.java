/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/13/22* Time: 2:30 PM
 *
 * Project: csci205_final_project
 * Package: group12.model
 * Class: ManageData
 *
 * Description:
 * Class to manage user Data
 * *****************************************/
package group12.model;

import java.io.*;

/**
 * Class to manage user Data
 */
public class ManageData
{
    /**
     * write object to a file
     * @param obj - object to serialize
     */
    public void writeData(Object obj)
    {
        try(FileOutputStream fs = new FileOutputStream("categories.bin"))
        {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(obj);
            os.close();
        } catch(FileNotFoundException e)
        {
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to read data from file
     * @return - object of serialized data
     */
    public Object readData()
    {
        try(FileInputStream fi = new FileInputStream("categories.bin")){
            ObjectInputStream is = new ObjectInputStream(fi);
            Object object = is.readObject();
            is.close();
            return object;
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}