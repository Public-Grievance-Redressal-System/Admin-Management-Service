package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import com.grievanceredressalsystem.adminmanagementservice.service.UserService;
import com.grievanceredressalsystem.adminmanagementservice.utils.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("/{id}/role")
    public User getUserRoleById(@PathVariable("id") UUID id) {

        if(userService.getUserById(id).isPresent())
            return userService.getUserById(id).get();
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        if(user.getUserRole() != UserRoleEnum.DEPT_ADMIN)
            user.setDepartmentId(null);
        userService.save(user);
        user.setPassword(null);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") UUID id) {
        var userObj = userService.saveOrUpdateUser(user, id);
        userObj.setPassword(null);
        return userObj;
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
