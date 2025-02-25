package [com.example.util](com.example.util);

import [org.slf4j.Logger](org.slf4j.Logger);
import [org.slf4j.LoggerFactory](org.slf4j.LoggerFactory);
import [org.springframework.boot.CommandLineRunner](org.springframework.boot.CommandLineRunner);
import [org.springframework.context.annotation.Bean](org.springframework.context.annotation.Bean);
import [org.springframework.context.annotation.Configuration](org.springframework.context.annotation.Configuration);

import [java.util.List](java.util.List);

@Configuration
public class DatabaseUtil {
    private static final Logger logger = [LoggerFactory.getLogger(DatabaseUtil.class)](LoggerFactory.getLogger(DatabaseUtil.class));

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AddressRepository addressRepository) {
        return args -> {
            [logger.info(](logger.info()"Initializing database...");
            // Логика инициализации базы данных
        };
    }
}