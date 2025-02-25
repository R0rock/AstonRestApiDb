package com.example.service;

import com.example.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    Optional<UserDTO> findById(Long id);
    List<UserDTO> findAll();
    void deleteById(Long id);
}