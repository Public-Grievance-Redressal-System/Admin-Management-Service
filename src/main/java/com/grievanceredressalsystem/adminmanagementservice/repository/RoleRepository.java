package com.grievanceredressalsystem.adminmanagementservice.repository;

import com.grievanceredressalsystem.adminmanagementservice.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
