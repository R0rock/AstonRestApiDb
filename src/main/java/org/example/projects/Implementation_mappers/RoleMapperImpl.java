package org.example.projects.Implementation_mappers;

import org.example.projects.communications.Role;
import org.example.projects.communications.RoleDTO;

public class RoleMapperImpl implements RoleMapper {
    @Override
    public Role toEntity(RoleDTO roleDTO) {
        // Реализуем логику перевода RoleDTO в Role
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setId(roleDTO.getId());
        return role;
    }

    @Override
    public RoleDTO toDto(Role role) {
        // Реализуем логику перевода Role в RoleDTO
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setId(role.getId());
        return roleDTO;
    }
}
