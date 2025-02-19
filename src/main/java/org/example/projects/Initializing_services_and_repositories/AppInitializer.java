package org.example.projects.Initializing_services_and_repositories;

import com.example.app.mapper.UserMapper;
import com.example.app.mapper.UserMapperImpl;
import com.example.app.repository.UserRepository;
import com.example.app.repository.impl.UserRepositoryImpl;
import com.example.app.service.UserService;

import java.sql.Connection;

public class AppInitializer {
    public static void main(String[] args) {
        Connection connection = DatabaseConnectionManager.getConnection();

        UserRepository userRepository = new UserRepositoryImpl(connection);
        UserMapper userMapper = new UserMapperImpl();
        UserService userService = new UserService(userRepository, userMapper);

        // Теперь вы можете использовать userService для выполнения операций CRUD
    }
}