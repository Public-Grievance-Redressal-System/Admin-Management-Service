package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import com.grievanceredressalsystem.adminmanagementservice.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUser() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") UUID id) {

        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") UUID userId) {
        if(userService.getUserById(userId).isPresent()) {
            userService.delete(userId);
            return "Successfully deleted!";
        }
        return "User not found!";
    }
}
