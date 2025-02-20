package org.example.projects.Implementation_of_services;

import org.example.projects.Implementation_mappers.UserMapper;
import org.example.projects.Repositories.UserRepository;
import org.example.projects.communications.UserDTO;
import org.example.projects.communications.User;
import org.example.projects.Repositories.RoleRepository;
import org.example.projects.Implementation_mappers.RoleMapper;
import org.example.projects.Implementation_of_services.RoleService;


import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;


    public UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            RoleRepository roleRepository,
            RoleMapper roleMapper
            ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleService = new RoleService(roleRepository, roleMapper);

        // Создаем RoleService с нужными параметрами
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