package com.example.demo.Service;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    UsersRepository usersRepository;
    public Users getProfile(Principal principal){
        Optional<Users> myp= usersRepository.findByEmail(principal.getName());
        return myp.get();
    }
    public Long getId(Principal principal) {
        String name = principal.getName();
        return usersRepository.findByEmail(name).get().getId();
    }

    }
