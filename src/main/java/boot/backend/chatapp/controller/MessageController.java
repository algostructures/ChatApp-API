package boot.backend.chatapp.controller;


import boot.backend.chatapp.model.Group;
import boot.backend.chatapp.model.Message;
import boot.backend.chatapp.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    ArrayList<Message> messages;
    ArrayList<Group> groups;
    ArrayList<User> users;

    @PostConstruct
    public void init(){
        messages = new ArrayList<>();
        groups = new ArrayList<>();
        users = new ArrayList<>();
    }

    @RequestMapping(path = "/{groupID}/getMessages", method = RequestMethod.GET)
    public ArrayList<Message> getMassages(@PathVariable String groupID){
        return (ArrayList<Message>) messages.stream().filter(message -> message.getGroup().equals(groupID)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/pushMessage", method = RequestMethod.POST)
    public boolean pushMassage(@RequestBody Message message){
        messages.add(message);
        return true;
    }

    @RequestMapping(path = "/getGroups/{userID}", method = RequestMethod.GET)
    public ArrayList<Group> getAllGroups (@PathVariable String userID){
        return (ArrayList<Group>) groups.stream().filter(group -> group.getUsers().stream().anyMatch(user -> user.getUserId().equals(userID))).collect(Collectors.toList());
    }


    @RequestMapping(path = "/addGroup", method = RequestMethod.POST)
    public boolean addGroup(@RequestBody Group group) {
        groups.add(group);
        return true;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        users.add(user);
        return true;
    }

    @RequestMapping(path = "/{groupID}/addUser", method = RequestMethod.POST)
    public ArrayList<Group> addUserToGroup(@PathVariable String groupID, @RequestBody User user) {
        Group g = groups.stream().filter(group -> group.getGroupID().equals(groupID)).collect(Collectors.toList()).get(0);
        g.addUser(user);
        return groups;
    }

    @RequestMapping(path = "/{username}/{password}",  method = RequestMethod.GET)
    public boolean login(@PathVariable String username, @PathVariable String password) {
        return users.stream().anyMatch(user -> user.getUserId().equals(username) && user.getPassword().equals(password));
    }
}
