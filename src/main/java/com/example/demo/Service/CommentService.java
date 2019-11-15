package com.example.demo.Service;

import com.example.demo.Repository.BlogRepository;
import com.example.demo.Repository.CommentsRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Blog;
import com.example.demo.modal.Comments;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    BlogRepository blogRepository;
    public Comments addComment(Long id, Comments comments, Long id1)
    {
        Optional<Users> users = usersRepository.findById(id);
        Optional<Blog> blog = blogRepository.findById(id1);
        comments.setBlog(blog.get());
        comments.setUsers(users.get());
        return commentsRepository.save(comments);
    }
    public Long getBlogId(Long id)
    {
        return blogRepository.findById(id).get().getId();
    }
}
