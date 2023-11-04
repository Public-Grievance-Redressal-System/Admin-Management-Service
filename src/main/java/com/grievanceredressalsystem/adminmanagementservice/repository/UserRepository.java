package com.grievanceredressalsystem.adminmanagementservice.repository;

import com.grievanceredressalsystem.adminmanagementservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
