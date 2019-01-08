package boot.backend.chatapp.model;


import org.springframework.stereotype.Component;

@Component
public class Message {
    int id;
    String contents;
    String group;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
