package forum.structures;

import forum.displayers.TopicsDisplay;
import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;

public class Sections implements Serializable
{
    public List<ListSectionTopic> sections = new LinkedList<>();

    public void addSection(String section)
    {
        Topics topics = new Topics(section);
        ListSectionTopic elem = new ListSectionTopic(section,topics);
        sections.add(elem);
    }

    public void deleteSection (String section)
    {
        for (ListSectionTopic elem : sections)
        {
            if (elem.section.equals(section))
            {
                sections.remove(elem);
                System.out.println("Pomyslnie usunieto.");
                return;
            }
        }
        System.out.println("Dana sekcja nie zostala znaleziona.");
    }

    public void showSection(String section)
    {
        for (ListSectionTopic elem : sections)
        {
            if (elem.section.equals(section))
            {
                TopicsDisplay.displayTopics(this,elem.topics);
            }
        }
        System.out.print("Dana sekcja nie zostala znaleziona");
    }

    public void printSections()
    {
        if(!sections.isEmpty())
        {
            System.out.println("Lista sekcji: ");
            for(ListSectionTopic elem : sections)
            {
                System.out.println(elem.section);
            }
            return;
        }
        System.out.println("Nie istnieje zadna sekcja :(");
    }
}