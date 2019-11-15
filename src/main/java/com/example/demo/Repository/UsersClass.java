package com.example.demo.Repository;

import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsersClass {
    @Autowired
    UsersRepository usersRepository;
    public void add(Users users)
    {
     System.out.println("Adding users");
     usersRepository.save(users);
    }
    public Optional<Users> getByEmail(String email)
    {
        System.out.println("Getting by email!!");
         return usersRepository.findByEmail(email);
    }
    public Optional<Users> getById(Long id)
    {
        return usersRepository.findById(id);
    }
}
