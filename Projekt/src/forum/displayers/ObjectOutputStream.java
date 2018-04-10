package forum.displayers;

import forum.structures.Sections;
import java.io.FileOutputStream;

class ObjectOutputStream // stworzona zeby nie duplikowac zapisu przy koncu programu , zapisuje obecny stan forum do pliku
{
    static void saveFile(Sections sections)
    {
        try
        {
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(new FileOutputStream("forum.txt"));
            objectOutputStream.writeObject(sections);
            objectOutputStream.close();
        }
        catch (Exception e) //problemy z zapisem pliku
        {
            e.printStackTrace();
        }
    }
}