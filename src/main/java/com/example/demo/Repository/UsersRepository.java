package com.example.demo.Repository;

import com.example.demo.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>
{
    @Override
 List<Users>findAll();
    Optional<Users> findByEmail(String email);
    Optional<Users> findById(Long id);
}
