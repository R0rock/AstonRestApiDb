package com.example.dto;

import com.example.entity.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AddressDTO {
    private User user;
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private LocalDateTime createdAt;

    // Конструкторы, геттеры и сеттеры
}