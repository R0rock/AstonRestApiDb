package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("John Doe");
        userDTO.setEmail("john@example.com");

        User user = UserMapper.INSTANCE.toEntity(userDTO);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO savedUser = userService.save(userDTO);
        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getName());
    }

    @Test
    void findById() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserDTO> foundUser = userService.findById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
    }

    @Test
    void saveWithInvalidData() {
        UserDTO userDTO = new UserDTO(); // Name and email are null
        assertThrows(ConstraintViolationException.class, () -> userService.save(userDTO));
    }

    @Test
    void findByIdNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        Optional<UserDTO> foundUser = userService.findById(1L);
        assertFalse(foundUser.isPresent());
    }
}