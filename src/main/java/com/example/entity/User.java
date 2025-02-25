package com.example.entity;

import lombok.Data;
import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private List<Address> addresses; // One-to-Many relationship
}