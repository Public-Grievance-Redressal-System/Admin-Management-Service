package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import com.grievanceredressalsystem.adminmanagementservice.service.UserService;
import com.grievanceredressalsystem.adminmanagementservice.utils.Utils;
import jakarta.security.auth.message.AuthException;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialNotFoundException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public User helloWorld(@RequestBody User user) {
        User userDbObj = userService.findUserByEmail(user.getEmail());
        System.out.println("Password in request : " + user.getPassword());
        System.out.println("Password in request after encryted : " + Utils.encoder.encode(user.getPassword()));
        System.out.println("Password received from DB : " + userDbObj.getPassword());
        if(Utils.encoder.matches(user.getPassword(), userDbObj.getPassword())) {
            User returnUser = new User();
            returnUser.setId(userDbObj.getId());
            returnUser.setEmail(userDbObj.getEmail());
            returnUser.setUserRole(userDbObj.getUserRole());
            returnUser.setPhoneNumber(userDbObj.getPhoneNumber());
            return returnUser;
        }
        throw new BadCredentialsException("Email/Password entered is invalid");
    }
}
