package com.example.demo.Service;

import com.example.demo.Repository.FriendsGroupRepository;
import com.example.demo.Repository.UsersClass;
import com.example.demo.modal.Followers;
import com.example.demo.modal.FriendsGroup;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.sax.SAXResult;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FriendsGroupService {
    @Autowired
    FriendsGroupRepository friendsGroupRepository;
    @Autowired
    UsersClass usersClass;
    private ArrayList<FriendsGroup> getGroupsFromCurrentUser(Principal principal) {
        Optional<Users> users = usersClass.getByEmail(principal.getName());
        ArrayList<FriendsGroup> friendsGroups = friendsGroupRepository.findAllByUsers(users);
        return friendsGroups;
    }
    public ArrayList<FriendsGroup> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users = usersClass.getByEmail(email);
        return friendsGroupRepository.findAllByUsers(users);
    }
    public String addFriends(Principal principal, Long id, String name) {
        Optional<Users> users = usersClass.getById(id);
        Optional<Users> users1 = usersClass.getByEmail(principal.getName());
        //ArrayList<Followers> followers = getFollowersFromCurrentUser(principal);
        FriendsGroup friendsGroup = new FriendsGroup();
        friendsGroup.setUsers1(users.get());
        friendsGroup.setUsers(users1.get());
        friendsGroup.setGroup_name(name);
        friendsGroupRepository.save(friendsGroup);
        return "\"Group created\"";
    }
    }
