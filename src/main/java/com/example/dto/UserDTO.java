package com.example.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.Valid;
import java.util.List;

@Data
public class UserDTO {
    @NotNull(message = "ID is required") // ID обязателен
    private Long id;

    @NotEmpty(message = "Name is required") // Имя обязательно
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") // Длина имени
    private String name;

    @Email(message = "Email should be valid") // Валидация email
    @NotEmpty(message = "Email is required") // Email обязателен
    private String email;

    @Valid // Валидация вложенных объектов
    private List<AddressDTO> addresses;
    private String username;
}
//@Data
//public class UserDTO {
//    @NotNull
//    private Long id;
//
//    @Size(min = 2, max = 50)
//    private String name;
//
//    private Long id;
//
//    @NotEmpty(message = "Name is required")
//    private String name;
//
//    @Email(message = "Email should be valid")
//    @NotEmpty(message = "Email is required")
//    private String email;
//
//    private List<AddressDTO> addresses;
//}