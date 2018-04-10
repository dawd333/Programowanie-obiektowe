package forum.structures;

import forum.displayers.DiscussionDisplay;
import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;

public class Topics implements Serializable
{
    private String section;
    public List<ListTopicDiscussion> discussions = new LinkedList<>();

    public Topics(String section)
    {
        this.section = section;
    }

    public void addDiscussion(String topic, String firstResponse)
    {
        Discussion dis = new Discussion(topic,firstResponse);
        ListTopicDiscussion elem = new ListTopicDiscussion(topic,dis);
        discussions.add(elem);
    }

    public void deleteDiscussion (String topic)
    {
        for (ListTopicDiscussion elem : discussions)
        {
            if (elem.topic.equals(topic))
            {
                discussions.remove(elem);
                System.out.println("Pomyslnie usunieto.");
                return;
            }
        }
        System.out.println("Dany temat nie zostal znaleziony, sprobuj ponownie.");
    }

    public void showDiscussion(Sections sections, String topic)
    {
        for (ListTopicDiscussion elem : discussions)
        {
            if (elem.topic.equals(topic))
            {
                DiscussionDisplay.displayDiscussion(sections,this,elem.discussion);
            }
        }
        System.out.print("Dana dyskusja nie zostala znaleziona");
    }

    public void printTopics(Topics topics)
    {
        System.out.println("Sekcja: " + topics.section);
        if(!topics.discussions.isEmpty())
        {
            System.out.println("Lista tematow: ");
            for(ListTopicDiscussion elem : topics.discussions)
            {
                System.out.println(elem.topic);
            }
            return;
        }
        System.out.println("Nie ma zadnego tematu :(");
    }
}