package com.example.demo.Controller;

import com.example.demo.Repository.FollowersRepository;
import com.example.demo.Service.FollowersService;
import com.example.demo.modal.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/f")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class FollowersController {
    @Autowired
    FollowersService followersService;
    @Autowired
    FollowersRepository followersRepository;
    @GetMapping("/followers")
    public ArrayList<Followers> getFollowers(Principal principal)
    {
        return followersService.getEmail(principal);
    }
    @GetMapping("/new/UserId/{id}")
    public String addNewFollower(@PathVariable("id") Long id,Principal principal)
    {
        return followersService.addFollower(principal,id);
    }
    @GetMapping("/delete/UserId/{id}")
    public String deleteFollower(@PathVariable("id")Long id,Principal principal)
    {
        return followersService.deleteFromFollowers(id, principal);
    }
}
