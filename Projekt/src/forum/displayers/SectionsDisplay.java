package forum.displayers;

import forum.structures.Sections;
import forum.structures.ListSectionTopic;
import java.io.Serializable;
import java.util.Scanner;

public class SectionsDisplay implements Serializable
{
    private static Scanner scan = new Scanner(System.in);

    public static void displaySections(Sections sections)
    {
        sections.printSections();
        System.out.println("Jesli chcesz dodac sekcje wpisz \"Dodaj\", jesli chesz usunac sekcje wpisz" +
                " \"Usun\", jesli chcesz zobaczyc tematy " +
                "w danej sekcji wpisz jej nazwe, jesli chcesz zakonczyc sesje wpisz \"Koniec\".");
        String temp = scan.nextLine();

        if (temp.equals("Dodaj"))
        {
            System.out.println("Podaj nazwe sekcji:");
            temp = scan.nextLine();
            if (temp.equals(""))
            {
                System.out.println("Nazwa sekcji nie moze byc pusta, sprobuj ponownie.");
            }
            else {
                for (ListSectionTopic elem : sections.sections)
                {
                    if (elem.section.equals(temp))
                    {
                        System.out.println("Sekcja o tej nazwie juz istnieje, sprobuj ponownie.");
                        displaySections(sections);
                    }
                }
                sections.addSection(temp);
                System.out.println("Pomyslnie dodano.");
            }
            displaySections(sections);
        }

        else if (temp.equals("Usun"))
        {
            System.out.println("Podaj nazwe sekcji:");
            temp = scan.nextLine();
            sections.deleteSection(temp);
            displaySections(sections);
        }

        else if (temp.equals("Koniec"))
        {
            ObjectOutputStream.saveFile(sections);
            System.out.println("Dzieki za sesje !");
            System.exit(0);
        }

        else {
            sections.showSection(temp);
            for (int i=0; i<2; i++)
            {
                System.out.println(",sprobuj jeszcze raz.");
                temp = scan.nextLine();
                sections.showSection(temp);
            }
            System.out.println(", to byla Twoja 3 proba, niestety nie znaleziono sekcji" +
                    " ktorej szukales :(");
            displaySections(sections);
        }
    }
}