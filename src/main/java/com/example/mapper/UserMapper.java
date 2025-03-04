package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressMapper.class) // Указываем, что используем AddressMapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "addresses", source = "addresses") // Указываем маппинг для коллекции
    UserDTO toDTO(User user);

    @Mapping(target = "addresses", source = "addresses") // Указываем маппинг для коллекции
    @Mapping(target = "username", source = "username")
    User toEntity(UserDTO userDTO);
}