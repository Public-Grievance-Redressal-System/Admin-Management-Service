package com.grievanceredressalsystem.adminmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/grievance")
public class GrievanceController {

    @Autowired
    RestTemplate restTemplate;

    @PatchMapping("/{grievanceId}/{departmentId}")
    public String transferGrievance(@PathVariable("departmentId") UUID departmentId, @PathVariable("grievanceId") UUID grievanceId) {
        return restTemplate.getForObject("http://localhost:8081/grievance/%s/%s".formatted(grievanceId, departmentId), String.class);
    }
}
