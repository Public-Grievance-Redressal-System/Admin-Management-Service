package com.grievanceredressalsystem.adminmanagementservice.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;


@Entity
@Table
@Data
public class User {
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPhoneNumber().equals(user.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPhoneNumber());
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String address;
}
