package com.example.repository;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsernameShouldReturnUser() {
        User user = new User();
        user.setUsername("test");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("test").orElse(null);
        assert(foundUser != null && foundUser.getUsername().equals("test"));
    }
}