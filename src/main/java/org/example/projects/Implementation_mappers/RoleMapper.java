package org.example.projects.Implementation_mappers;

import com.example.app.dto.RoleDTO;
import com.example.app.entity.Role;

public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDto(Role role);
}