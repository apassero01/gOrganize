/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Andrew Passero
 * Section: Section 2 11am
 * Date: 11/6/22* Time: 2:52 PM
 *
 * Project: csci205_final_project
 * Package: group12.model
 * Class: ArticleResource
 *
 * Description:
 *
 * *****************************************/
package group12.model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ArticleResource extends Resource
{
    private Scanner scnr;

    private String articleContents;

    public ArticleResource(String name, String description,String URL)
    {
        super(name,description,URL,ResourceType.ARTICLE);
        parseArticle();

    }
    private void parseArticle()
    {
        try(BufferedInputStream in = new BufferedInputStream(new URL(this.resourceLocator).openStream()))
        {
            String contents;
            scnr = new Scanner(in);
            StringBuffer sb = new StringBuffer();
            while(scnr.hasNext()) {
                sb.append(scnr.next());
            }
            contents=sb.toString();
//            this.articleContents = contents.replaceAll("<[^>]*>", "");
            this.articleContents = contents;
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.out.printf("Cannot connect to site, try again");
        }
    }

    @Override
    public void displayResource()
    {
        System.out.println(this.articleContents);
    }


}