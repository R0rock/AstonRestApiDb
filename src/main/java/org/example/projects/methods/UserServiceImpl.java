package org.example.projects.methods;

import org.example.projects.communications.UserDTO;
import org.example.projects.communications.User;
import org.example.projects.Implementation_mappers.UserMapper;
import org.example.projects.Repositories.UserRepository;
import org.example.projects.Implementation_of_services.UserService;



import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userRepository.update(userMapper.toEntity(userDTO));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}