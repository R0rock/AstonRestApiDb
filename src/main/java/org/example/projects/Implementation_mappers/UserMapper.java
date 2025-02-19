package org.example.projects.Implementation_mappers;


import org.example.projects.communications.User;
import org.example.projects.communications.UserDTO;

public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
}