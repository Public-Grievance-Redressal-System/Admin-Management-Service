package com.grievanceredressalsystem.adminmanagementservice.service;

import com.grievanceredressalsystem.adminmanagementservice.model.Department;
import com.grievanceredressalsystem.adminmanagementservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        var departments = new ArrayList<Department>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Optional<Department> getDepartmentById(UUID id) {
        return departmentRepository.findById(id);
    }

    public void saveOrUpdate(Department department) {
        departmentRepository.save(department);
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }
}
