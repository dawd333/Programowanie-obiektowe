package forum.structures;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;

public class Discussion implements Serializable
{
    private String topic;
    private List<String> posts = new LinkedList<>();

    public Discussion(String topic, String firstResponse)
    {
        this.topic = topic;
        posts.add(firstResponse);
    }

    public void addResponse(String response)
    {
        posts.add(response);
    }

    public void deleteResponse (int index)
    {
        try
        {
            posts.remove(index-1);
            System.out.println("Pomyslnie usunieto.");
        }
        catch(IndexOutOfBoundsException e) //wyrzuca gdy zostanie podany zly indeks odpowiedzi
        {
            System.out.println("Podany indeks odpowiedzi nie miesci sie w zakresie.");
        }
    }

    public void printResponses(Discussion discussion)
    {
       System.out.println("Temat: " + discussion.topic);
       if(!discussion.posts.isEmpty())
       {
           System.out.println("Odpowiedzi: ");
           for (String elem : discussion.posts)
           {
               System.out.println(elem);
           }
       }
       else{
           System.out.println("Nie ma zadnej odpowiedzi :(");
       }
    }
}