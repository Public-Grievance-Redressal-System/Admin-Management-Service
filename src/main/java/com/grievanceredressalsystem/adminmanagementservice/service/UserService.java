package com.grievanceredressalsystem.adminmanagementservice.service;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import com.grievanceredressalsystem.adminmanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        var users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
