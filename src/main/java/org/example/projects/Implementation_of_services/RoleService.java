package org.example.projects.Implementation_of_services;

import com.example.app.dto.RoleDTO;
import com.example.app.entity.Privilege;
import com.example.app.entity.Role;
import com.example.app.mapper.RoleMapper;
import com.example.app.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        return roleMapper.toDto(roleRepository.findById(id));
    }

    public void createRole(RoleDTO roleDTO) {
        roleRepository.save(roleMapper.toEntity(roleDTO));
    }

    public void updateRole(RoleDTO roleDTO) {
        roleRepository.update(roleMapper.toEntity(roleDTO));
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    public List<Role> findRolesByIds(List<Long> ids) {
        return roleRepository.findAll().stream()
                .filter(role -> ids.contains(role.getId()))
                .collect(Collectors.toList());
    }

    public void addPrivilegeToRole(Long roleId, Long privilegeId) {
        Role role = roleRepository.findById(roleId);
        if (role == null) {
            throw new IllegalArgumentException("Role not found with id: " + roleId);
        }
        Privilege privilege = new Privilege(privilegeId, ""); // Предположим, что имя привиллегии не важно
        role.getPrivileges().add(privilege);
        roleRepository.update(role);
    }
}