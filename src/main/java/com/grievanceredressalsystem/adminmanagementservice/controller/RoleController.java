package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.Role;
import com.grievanceredressalsystem.adminmanagementservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getRole() {

        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable("id") UUID id) {

        return roleService.getRoleById(id);
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        roleService.saveOrUpdate(role);
        return role;
    }

    @PutMapping
    public Role updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return role;
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable("id") UUID roleId) {
        if(roleService.getRoleById(roleId).isPresent()) {
            roleService.delete(roleId);
            return "Successfully deleted!";
        }
        return "Role not found!";
    }
}
