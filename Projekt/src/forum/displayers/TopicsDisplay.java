package forum.displayers;

import forum.structures.Topics;
import forum.structures.ListTopicDiscussion;
import forum.structures.Sections;
import java.io.Serializable;
import java.util.Scanner;

public class TopicsDisplay implements Serializable
{
    private static Scanner scan = new Scanner(System.in);

    public static void displayTopics(Sections sections, Topics topics)
    {
        topics.printTopics(topics);
        System.out.println("Jesli chcesz dodac temat wpisz \"Dodaj\", jesli chesz usunac temat wpisz" +
                " \"Usun\", jesli chcesz zobaczyc dyskusje " +
                "w danym temacie wpisz jego nazwe, jesli chcesz cofnac sie do listy sekcji" +
                " wpisz \"Cofnij\", jesli chcesz zakonczyc sesje wpisz \"Koniec\".");
        String temp = scan.nextLine();

        if (temp.equals("Dodaj"))
        {
            System.out.println("Podaj nazwe tematu:");
            temp = scan.nextLine();
            if (temp.equals(""))
            {
                System.out.println("Nazwa tematu nie moze byc pusta, sprobuj ponownie.");
            }
            else
                {
                System.out.println("Podaj pierwsza wypowiedz:");
                String firstrespone = scan.nextLine();
                if (firstrespone.equals(""))
                {
                    System.out.println("Pierwsza wypowiedz nie moze byc pusta, sprobuj ponownie.");
                }
                else {
                    for (ListTopicDiscussion elem : topics.discussions)
                    {
                        if (elem.topic.equals(temp))
                        {
                            System.out.println("Temat o tej nazwie juz istnieje, sprobuj ponownie.");
                            displayTopics(sections,topics);
                        }
                    }
                    topics.addDiscussion(temp,firstrespone);
                    System.out.println("Pomyslnie dodano.");
                }
            }
            displayTopics(sections,topics);
        }

        else if (temp.equals("Usun"))
        {
            System.out.println("Podaj nazwe tematu:");
            temp = scan.nextLine();
            topics.deleteDiscussion(temp);
            displayTopics(sections,topics);
        }

        else if (temp.equals("Koniec"))
        {
            ObjectOutputStream.saveFile(sections);
            System.out.println("Dzieki za sesje !");
            System.exit(0);
        }

        else if (temp.equals("Cofnij"))
        {
            SectionsDisplay.displaySections(sections);
        }

        else {
            topics.showDiscussion(sections,temp);
            for (int i=0; i<2; i++)
            {
                System.out.println(", sprobuj jeszcze raz.");
                temp = scan.nextLine();
                topics.showDiscussion(sections,temp);
            }
            System.out.println(", to byla Twoja 3 proba, niestety nie znaleziono tematu" +
                    " ktorego szukales :(");
            displayTopics(sections, topics);
        }
    }
}