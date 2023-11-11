package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.utils.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping
    public List<UserRoleEnum> getRole() {
        return Arrays.stream(UserRoleEnum.class.getEnumConstants()).toList();
    }

    /*@GetMapping("/{id}")
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
    }*/
}
