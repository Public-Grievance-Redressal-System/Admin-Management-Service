package com.grievanceredressalsystem.adminmanagementservice.repository;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
}
