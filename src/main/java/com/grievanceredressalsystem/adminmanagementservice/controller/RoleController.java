package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.Role;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Map<UUID, Role> roleTable = new HashMap<>();

    @GetMapping
    public List<Role> getRole() {

        return roleTable.keySet().stream().map(roleTable::get).toList();
//        return "Inside get Role method!";
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        role.setId(UUID.randomUUID());
        roleTable.put(role.getId(), role);
        return role;
//        return "Inside create Role method!";
    }

    @PutMapping
    public String updateRole(@RequestBody Role role) {
        if(roleTable.containsKey(role.getId())) {
            roleTable.put(role.getId(), role);
            return "Role updated successfully!";
        }
        return "Role not found!";
    }

    @DeleteMapping
    public String deleteRole(@PathParam("id") UUID roleId) {
        if(roleTable.containsKey(roleId))
            if(roleTable.remove(roleId, roleTable.get(roleId))) {
                return "Role successfully deleted!";
            } else {
                return "Failed to delete Role!";
            }
        return "Role not found!";
    }
}
