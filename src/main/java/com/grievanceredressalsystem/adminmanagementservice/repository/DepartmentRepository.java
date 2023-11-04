package com.grievanceredressalsystem.adminmanagementservice.repository;

import com.grievanceredressalsystem.adminmanagementservice.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> {
}
