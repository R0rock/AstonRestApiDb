package org.example.projects.Implementation_mappers;

import com.example.app.dto.UserDTO;
import com.example.app.entity.User;

public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
}