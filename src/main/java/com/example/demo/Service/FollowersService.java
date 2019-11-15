package com.example.demo.Service;

import com.example.demo.Repository.FollowersRepository;
import com.example.demo.Repository.UsersClass;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Followers;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FollowersService {
    @Autowired
    FollowersRepository followersRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersClass usersClass;
    private ArrayList<Followers> getFollowersFromCurrentUser(Principal principal) {
        Optional<Users> users = usersClass.getByEmail(principal.getName());
        ArrayList<Followers> followers = followersRepository.findAllByUsers(users);
        return followers;
    }
    public ArrayList<Followers> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users = usersClass.getByEmail(email);
        return followersRepository.findAllByUsers(users);
    }
    public String addFollower(Principal principal, Long id) {
        Optional<Users> users = usersClass.getById(id);
        Optional<Users> users1 = usersClass.getByEmail(principal.getName());
        //ArrayList<Followers> followers = getFollowersFromCurrentUser(principal);
        Followers followers = new Followers();
        followers.setUsers1(users.get());
        followers.setUsers(users1.get());
        followersRepository.save(followers);
        return "\"Follower added\"";
    }
    @Transactional
    public String deleteFromFollowers(Long id,Principal principal)
    {
        Optional<Users> users1= usersClass.getById(id);
        Optional<Users> users = usersClass.getByEmail(principal.getName());
        followersRepository.deleteByUsersAndUsers1(users,users1);
        return "\"Follower deleted\"";
    }
}
