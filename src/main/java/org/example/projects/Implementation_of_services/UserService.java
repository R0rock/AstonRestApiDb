package org.example.projects.Implementation_of_services;

import com.example.app.dto.UserDTO;
import com.example.app.entity.User;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id));
    }

    public void createUser(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
    }

    public void updateUser(UserDTO userDTO) {
        userRepository.update(userMapper.toEntity(userDTO));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void assignRolesToUser(Long userId, List<Long> roleIds) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
        RoleService roleService = new RoleService(); // Предположим, что роль-сервис доступен
        user.setRoles(roleService.findRolesByIds(roleIds));
        userRepository.update(user);
    }
}