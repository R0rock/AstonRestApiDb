package org.example.projects.communications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 *     @Data: Аннотация Lombok, которая автоматически генерирует геттеры, сеттеры, конструктор, toString(), equals() и hashCode().
 *     @NoArgsConstructor: Создает конструктор без аргументов.
 *     @AllArgsConstructor: Создает конструктор с аргументами для всех полей.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Getter
    private Long id;
    private String roleName;
    private Set<Privilege> privileges;

    public Set<Privilege> getPrivileges() {
        return privileges;
    }
}