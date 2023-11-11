package com.grievanceredressalsystem.adminmanagementservice.service;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import com.grievanceredressalsystem.adminmanagementservice.repository.UserRepository;
import com.grievanceredressalsystem.adminmanagementservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
        userRepository.findAll().forEach(user -> {
            user.setPassword(null);
            users.add(user);
        });
        return users;
    }

    public Optional<User> getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            user.get().setPassword(null);
            return user;
        }
        return Optional.empty();
    }

    public void save(User user) {
        user.setPassword(Utils.encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public User saveOrUpdateUser(User user, UUID id) {
        return userRepository.findById(id)
                .map(userObj -> {
                    user.setId(id);
                    return userRepository.save(user);
                })
                .orElseGet(() -> userRepository.save(user));
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
