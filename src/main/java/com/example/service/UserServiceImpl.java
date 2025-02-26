package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

//    private final UserRepository userRepository;
//    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        logger.info("Saving user: {}", userDTO.getName());
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        logger.info("Finding user by ID: {}", id);
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }

    @Override
    public List<UserDTO> findAll() {
        logger.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting user by ID: {}", id);
        userRepository.deleteById(id);
    }
}