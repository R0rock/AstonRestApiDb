package org.example.projects.Repositories;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
    Role findById(Long id);
    void save(Role role);
    void update(Role role);
    void deleteById(Long id);
}