package com.example.mapper;

import com.example.dto.AddressDTO;
import com.example.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
//public interface AddressMapper {
//    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
//
//    @Mapping(target = "createdAt", source = "address.createdAt")
//    AddressDTO toDto(Address address);
//
//    @Mapping(target = "id", ignore = true)
//    Address toEntity(AddressDTO addressDTO);
//}
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "createdAt", source = "createdAt") // Явно указываем маппинг для createdAt
    AddressDTO toDto(Address address);

    @Mapping(target = "id", ignore = true) // Игнорируем id при преобразовании в сущность
    @Mapping(target = "createdAt", source = "createdAt") // Явно указываем маппинг для createdAt
    Address toEntity(AddressDTO addressDTO);
}