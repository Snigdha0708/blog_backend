package com.example.demo.Controller;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abc")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class SignUp
{
    @Autowired
    UsersRepository u;
    @PostMapping(value = "/somedata" , consumes = "application/json")
    public Users signUp(@RequestBody Users user)
    {
        user.setActive(1);
        user.setAuthorization("basic");
        // user.setId(user.id++);
        System.out.println("Working");
        u.save(user);
        return user;
    }
}