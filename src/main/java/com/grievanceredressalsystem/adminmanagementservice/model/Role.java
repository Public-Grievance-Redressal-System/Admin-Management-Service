package com.grievanceredressalsystem.adminmanagementservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Role {
    private UUID id;
    private String name;
    private String description;
}
