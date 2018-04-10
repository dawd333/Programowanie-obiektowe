package forum.displayers;

import forum.structures.Sections;
import forum.structures.Topics;
import forum.structures.Discussion;
import java.io.Serializable;
import java.util.Scanner;

public class DiscussionDisplay implements Serializable
{
    private static Scanner scan = new Scanner(System.in);

    public static void displayDiscussion(Sections sections, Topics topics, Discussion discussion)
    {
        discussion.printResponses(discussion);
        System.out.println("Jesli chcesz dodac odpowiedz wpisz \"Dodaj\", jesli chesz usunac odpowiedz" +
                " wpisz \"Usun\", jesli chcesz cofnac sie do listy tematow" +
                " wpisz \"Cofnij\", jesli chcesz zakonczyc sesje wpisz \"Koniec\".");
        String temp = scan.nextLine();

        if (temp.equals("Dodaj"))
        {
            System.out.println("Podaj tresc odpowiedzi:");
            temp = scan.nextLine();
            if (temp.equals(""))
            {
                System.out.println("Odpowiedz nie moze byc pusta, sprobuj ponownie.");
            }
            else {
                discussion.addResponse(temp);
                System.out.println("Pomyslnie dodano.");
            }
            displayDiscussion(sections, topics,discussion);
        }

        else if (temp.equals("Usun"))
        {
            try
            {
                System.out.println("Podaj numer odpowiedzi ktora chcesz usunac:");
                temp = scan.nextLine();
                int index = Integer.parseInt(temp);
                discussion.deleteResponse(index);
            }
            catch (NumberFormatException e) //nie podanie liczby jako argumentu
            {
                System.out.println("Powinienes podac liczbe.");
            }
            finally
            {
                displayDiscussion(sections,topics,discussion);
            }
        }

        else if (temp.equals("Koniec"))
        {
            ObjectOutputStream.saveFile(sections);
            System.out.println("Dzieki za sesje !");
            System.exit(0);
        }

        else if (temp.equals("Cofnij"))
        {
            TopicsDisplay.displayTopics(sections, topics);
        }

        else {
            System.out.println("Nie ma takiej opcji, sprobuj ponownie.");
            displayDiscussion(sections,topics,discussion);
        }
    }
}