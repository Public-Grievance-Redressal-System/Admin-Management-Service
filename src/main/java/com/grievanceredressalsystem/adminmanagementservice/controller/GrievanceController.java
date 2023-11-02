package com.grievanceredressalsystem.adminmanagementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grievance")
public class GrievanceController {

    @GetMapping
    public String transferGrievance() {
        return "Inside transfer grievance api";
    }
}
