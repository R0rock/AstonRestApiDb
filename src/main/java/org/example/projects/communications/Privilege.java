package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *     @Data: Аннотация Lombok, которая автоматически генерирует геттеры, сеттеры, конструктор, toString(), equals() и hashCode().
 *     @NoArgsConstructor: Создает конструктор без аргументов.
 *     @AllArgsConstructor: Создает конструктор с аргументами для всех полей.
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {
    private Long id;
    private String privilegeName;
}