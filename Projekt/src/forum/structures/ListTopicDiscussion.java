package forum.structures;

import java.io.Serializable;

public class ListTopicDiscussion implements Serializable //obiekt do listy w tematach, przechowuje nazwe tematu + odpowiedzi do niego
{
    public String topic;
    public Discussion discussion;

    public ListTopicDiscussion(String topic, Discussion discussion)
    {
        this.topic = topic;
        this.discussion = discussion;
    }
}