package org.example.projects.Implementation_mappers;

import org.example.projects.communications.User;
import org.example.projects.communications.UserDTO;

public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        // Преобразование полей из DTO в Entity
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setId(userDTO.getId());
        // Добавьте другие поля, если они есть

        return user;
    }

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        // Преобразование полей из Entity в DTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setId(user.getId());
        // Добавьте другие поля, если они есть

        return userDTO;
    }
}