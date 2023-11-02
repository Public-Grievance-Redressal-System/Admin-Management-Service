package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import jakarta.websocket.server.PathParam;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Map<UUID, User> userTable = new HashMap<>();

    @GetMapping
    public List<User> getUser() {

        return userTable.keySet().stream().map(userTable::get).toList();
//        return "Inside get user method!";
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        /*if(userList!= null && userList.contains(user)) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("User object already exist");
            System.out.println("-------------------------------------------------------------------------");
            return user;
        }*/
        user.setId(UUID.randomUUID());
        userTable.put(user.getId(), user);
        return user;
//        return "Inside create user method!";
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        if(userTable.containsKey(user.getId())) {
            userTable.put(user.getId(), user);
            return "User updated successfully!";
        }
        /*if(userList.remove(user)) {
            userList.add(user);
            return "User updated successfully!";
        }*/
        return "User not found!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathParam("id") UUID userId) {
        if(userTable.containsKey(userId))
            if(userTable.remove(userId, userTable.get(userId))) {
                return "Successfully deleted!";
            } else {
                return "Failed to delete User!";
            }
        return "User not found!";
    }
}
