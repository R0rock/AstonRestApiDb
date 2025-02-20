package org.example.projects.Initializing_services_and_repositories;

import org.example.projects.Implementation_mappers.UserMapper;
import org.example.projects.Implementation_mappers.UserMapperImpl;
import org.example.projects.Repositories.UserRepository;
import org.example.projects.methods.UserRepositoryImpl;
import org.example.projects.Implementation_of_services.UserService;

import org.example.projects.Connecting_database.DatabaseConnectionManager;
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