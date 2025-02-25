package com.example.service;

import com.example.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    Optional<UserDTO> findById(Long id);
    List<UserDTO> findAll();
    void deleteById(Long id);
}