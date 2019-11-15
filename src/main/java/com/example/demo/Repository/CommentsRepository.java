package com.example.demo.Repository;

import com.example.demo.modal.Comments;
import com.example.demo.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
    ArrayList<Comments> findAllByUsers(Optional<Users> users);
}
