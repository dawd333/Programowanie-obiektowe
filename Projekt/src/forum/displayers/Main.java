package forum.displayers;

import forum.structures.Sections;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Witam w moim forum !");
        try
        {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("forum.txt"));
            Sections sections = (Sections) objectInputStream.readObject();
            SectionsDisplay.displaySections(sections);
        }
        catch (FileNotFoundException e) // gdy nie ma jeszcze stworzonego pliku forum z ktorego mozna wczytac
        {
            Sections sections = new Sections();
            SectionsDisplay.displaySections(sections);
        }
        catch (Exception e) // inne problemy z wczytaniem pliku typu EOF
        {
            e.printStackTrace();
        }
    }
}