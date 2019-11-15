package com.example.demo.Controller;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.Service.ProfileService;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/myprofile")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class MyProfile {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ProfileService profileService;
    @GetMapping("/get")
    public Users getData(Principal principal){
        return profileService.getProfile(principal);
    }
    @PutMapping("/update")
    public Users update(@Valid @RequestBody Users users) {
        users.setActive(1);
        users.setAuthorization("basic");
        usersRepository.save(users);
        return users;
    }
}

