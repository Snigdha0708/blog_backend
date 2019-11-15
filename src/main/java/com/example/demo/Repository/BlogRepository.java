package com.example.demo.Repository;

import com.example.demo.modal.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>
{
    @Override
    List<Blog>findAll();
    List<Blog> findByCategoryContaining(String category);
}
