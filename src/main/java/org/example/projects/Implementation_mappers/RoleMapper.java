package org.example.projects.Implementation_mappers;

import org.example.projects.communications.Role;
import org.example.projects.communications.RoleDTO;

public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDto(Role role);
}