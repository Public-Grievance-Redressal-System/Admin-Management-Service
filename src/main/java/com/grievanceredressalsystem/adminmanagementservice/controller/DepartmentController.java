package com.grievanceredressalsystem.adminmanagementservice.controller;

import com.grievanceredressalsystem.adminmanagementservice.model.Department;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    public static Map<UUID, Department> departmentTable = new HashMap<>();

    @GetMapping
    public List<Department> getDepartment() {
        return departmentTable.keySet().stream().map(departmentTable::get).toList();
//        return "Inside get Department method!";
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        UUID deptId = UUID.randomUUID();
        department.setId(deptId);
        departmentTable.put(deptId, department);
        return department;
    }

    @PutMapping
    public String updateDepartment(@RequestBody Department department) {
        var deptId = department.getId();
        if(departmentTable.containsKey(deptId)) {
            department.setId(deptId);
            departmentTable.put(deptId, department);
            return "Department updated successfully!";
        }
        return "Department with ID %s not found!".formatted(deptId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathParam("id") UUID deptId) {
        if(departmentTable.containsKey(deptId))
            if(departmentTable.remove(deptId, departmentTable.get(deptId))) {
                return "Department deleted successfully!";
            } else {
                return "Failed to delete department!";
            }
        return "Department with ID %s not found!".formatted(deptId);
    }
}
