package com.example.demo.Controller;

import com.example.demo.Repository.CommentsRepository;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.ProfileService;
import com.example.demo.modal.Blog;
import com.example.demo.modal.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class CommentController {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    ProfileService profileService;
    @Autowired
    CommentService commentService;
    @PostMapping("/addComment/{id}")
    public Comments newComment(@Valid @RequestBody Comments comments, Principal principal, @PathVariable(value = "id")Long id)
    {
        System.out.println("New Comment");
        return commentService.addComment(profileService.getId(principal),comments,commentService.getBlogId(id));
    }
    @GetMapping("/getComments")
    public List<Comments> getAll()
    {
        return commentsRepository.findAll();
    }
}
