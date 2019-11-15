package com.example.demo.Repository;

import com.example.demo.modal.Followers;
import com.example.demo.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FollowersRepository extends CrudRepository<Followers,Long> {
    ArrayList<Followers> findAllByUsers(Optional<Users> users);
    void deleteByUsers(Optional<Users> users1);
    void deleteByUsersAndUsers1(Optional<Users> users,Optional<Users> users1);
}
