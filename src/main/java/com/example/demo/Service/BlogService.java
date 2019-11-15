package com.example.demo.Service;

import com.example.demo.Repository.BlogRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.modal.Blog;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BlogRepository blogRepository;

    public Blog addBlog(Long id, Blog blog) {
        Optional<Users> users = usersRepository.findById(id);
        blog.setUsers(users.get());
        return blogRepository.save(blog);
    }

    @Transactional
    public String deleteFromBlog(Long id) {
        blogRepository.deleteById(id);
        return "\"blog deleted\"";
    }
}
