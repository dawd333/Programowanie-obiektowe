package forum.structures;

import java.io.Serializable;

public class ListSectionTopic implements Serializable //obiekt do listy w sekcjach , przechowuje nazwe sekcji + powiazanie tematy
{
    public String section;
    public Topics topics;

    public ListSectionTopic(String section, Topics topics)
    {
        this.section = section;
        this.topics = topics;
    }
}