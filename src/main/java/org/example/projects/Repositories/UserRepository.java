package org.example.projects.Repositories;

import org.example.projects.communications.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void deleteById(Long id);
}