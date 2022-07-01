package com.example.users.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
public class RoleEntity extends AuditEntity {
    private String name;
}
