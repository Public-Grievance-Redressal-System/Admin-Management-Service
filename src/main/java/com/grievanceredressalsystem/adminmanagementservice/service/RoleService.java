package com.grievanceredressalsystem.adminmanagementservice.service;

import com.grievanceredressalsystem.adminmanagementservice.model.Role;
import com.grievanceredressalsystem.adminmanagementservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        var roles = new ArrayList<Role>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Optional<Role> getRoleById(UUID id) {
        return roleRepository.findById(id);
    }

    public void saveOrUpdate(Role role) {
        roleRepository.save(role);
    }

    public void delete(UUID id) {
        roleRepository.deleteById(id);
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }
}
