package com.example.demo.Controller;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BlogRepository;
import com.example.demo.Service.BlogService;
import com.example.demo.Service.ProfileService;
import com.example.demo.modal.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class BlogController
{
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogService blogService;
    @Autowired
    ProfileService profileService;
    @PostMapping("/addBlog")
    public Blog newBlog(@Valid @RequestBody Blog blog, Principal principal)
    {
        return blogService.addBlog(profileService.getId(principal),blog);
    }
    @GetMapping("/getBlogs")
    public List<Blog> getAll()
    {
        return blogRepository.findAll();
    }
    @PostMapping("/updateBlog")
    public Blog updateBlog(@Valid @RequestBody Blog blog, Principal principal)
    {
        return blogService.addBlog(profileService.getId(principal),blog);
    }
    @GetMapping("/par/{id}")
    public Blog getDetailsById(@PathVariable(value="id")Long id)
    {
        return blogRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Details","Id",id));
    }

    @GetMapping("/search/{name}")
    public List<Blog> getSearch(@PathVariable(value = "name")String category)
    {
        return blogRepository.findByCategoryContaining(category);
    }
    @GetMapping("/delete/UserId/{id}")
    public String deleteBlog(@PathVariable("id")Long id) {
      return blogService.deleteFromBlog(id);
    }
}
