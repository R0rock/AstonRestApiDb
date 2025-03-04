package com.example.util;

import com.example.entity.User;
import com.example.entity.Address;
import com.example.repository.UserRepository;
import com.example.repository.AddressRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.List;

@Configuration
public class DatabaseUtil {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AddressRepository addressRepository) {
        return args -> {
            logger.info("Initializing database with test data...");

            User user = new User();
            user.setName("John Doe");
            user.setEmail("john.doe@example.com");
            userRepository.save(user);

            Address address = new Address();
            address.setStreet("Main St");
            address.setCity("New York");
            address.setZipCode("10001");
            address.setUser(user);
            addressRepository.save(address);

            logger.info("Database initialized successfully.");
        };
    }
}