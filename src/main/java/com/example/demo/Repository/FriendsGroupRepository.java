package com.example.demo.Repository;

import com.example.demo.modal.FriendsGroup;
import com.example.demo.modal.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FriendsGroupRepository extends CrudRepository<FriendsGroup,Long> {
    ArrayList<FriendsGroup> findAllByUsers(Optional<Users> users);
}
