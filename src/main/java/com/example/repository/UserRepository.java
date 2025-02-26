package com.example.repository;

import com.example.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}