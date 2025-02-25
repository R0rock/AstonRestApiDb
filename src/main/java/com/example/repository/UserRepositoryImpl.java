package com.example.repository;

import com.example.entity.User;
import com.example.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User save(User user) {
        // JDBC code to save user
    }

    @Override
    public Optional<User> findById(Long id) {
        // JDBC code to find user by id
    }

    @Override
    public List<User> findAll() {
        // JDBC code to find all users
    }

    @Override
    public void deleteById(Long id) {
        // JDBC code to delete user by id
    }
}