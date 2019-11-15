package com.example.demo.Controller;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UsersController
{
    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/addUser")
    public Users newUser(@Valid @RequestBody Users users)
    {
        return usersRepository.save(users);
    }
    @GetMapping("/getUsers")
    public List<Users> allUsers()
    {
       return usersRepository.findAll();
    }
    @GetMapping("/validuser")
    public String valUser(Principal principal)
    {
        System.out.println("Logging in user"+principal.getName());
        //this.principal=principal;
        return "\"user successfully authenticated\"";
    }
    @GetMapping("/user")
    public Optional<Users> curUser(Principal principal)
    {
        System.out.println("Logging in user"+principal.getName());
        //this.principal=principal;
        return usersRepository.findByEmail(principal.getName());
    }
}
