package com.example.util;

import com.example.repository.UserRepository;
import com.example.repository.AddressRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseUtil {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AddressRepository addressRepository) {
        return args -> {
            logger.info("Initializing database...");
            // Логика инициализации базы данных
        };
    }
}