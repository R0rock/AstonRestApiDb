package com.example.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import java.util.List;

@Data
public class UserDTO {
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    private List<AddressDTO> addresses;
}