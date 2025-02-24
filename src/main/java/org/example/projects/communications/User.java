package org.example.projects.communications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 *     @Data: Аннотация Lombok, которая автоматически генерирует геттеры, сеттеры, конструктор, toString(), equals() и hashCode().
 *     @NoArgsConstructor: Создает конструктор без аргументов.
 *     @AllArgsConstructor: Создает конструктор с аргументами для всех полей.
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<Role> roles;

    public void setRoles(Set<Role> roles) {
        [this.roles](this.roles) = roles;
    }
}