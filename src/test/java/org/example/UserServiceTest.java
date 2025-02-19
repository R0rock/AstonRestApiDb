package com.example.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testGetAllUsers(int numUsers) {
        // Arrange
        List<User> expectedUsers = Arrays.asList(new User(), new User(), new User());
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // Act
        List<UserDTO> actualUsers = userService.getAllUsers();

        // Assert
        assertEquals(numUsers, actualUsers.size());
    }

    @Test
    void testAssignRolesToUser() {
        // Arrange
        User user = new User(1L, "John Doe", 30, null);
        when(userRepository.findById(any())).thenReturn(user);

        RoleService roleService = new RoleService(null, null); // В реальной жизни лучше использовать mock
        when(roleService.findRolesByIds(any())).thenReturn(Arrays.asList(new Role()));

        // Act
        userService.assignRolesToUser(1L, Arrays.asList(1L));

        // Assert
        assertEquals(1, user.getRoles().size());
    }
}