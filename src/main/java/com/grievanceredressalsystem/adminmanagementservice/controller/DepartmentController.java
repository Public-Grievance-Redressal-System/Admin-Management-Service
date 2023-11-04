package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.Department;
import com.grievanceredressalsystem.adminmanagementservice.service.DepartmentService;
import jakarta.websocket.server.PathParam;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") UUID id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        departmentService.saveOrUpdate(department);
        return department;
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
        return department;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathParam("id") UUID deptId) {
        if(departmentService.getDepartmentById(deptId).isPresent()) {
            departmentService.delete(deptId);
            return "Successfully deleted!";
        }
        return "Department not found!";
    }
}
