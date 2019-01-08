package boot.backend.chatapp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Group {

    String groupID;
    String groupName;
    ArrayList<User> users;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public Group(String groupID) {
        this.groupID = groupID;
    }

    public Group() {
        users = new ArrayList<>();
    }

    public Group(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
