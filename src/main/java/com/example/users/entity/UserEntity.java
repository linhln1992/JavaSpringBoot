package com.example.users.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class UserEntity extends AuditEntity {
    @NotNull(message = "Chua nhap name")
    private String name;

//    @NotNull(message = "chua nhap birthday")
    private Date birthday;

//    @NotNull(message = "chua nhap phone")
//    @Pattern(message = "sai dinh dang phone", regexp = "^[0-9]\\d{10}$")
    private String phone;

//    @NotNull(message = "chua nhap email")
//    @Email(message = "sai dinh dang email", regexp = "^(.+)@(\\S+)$")
    private String email;

//    @NotNull(message = "chua nhap address")
    private String address;

//    @NotNull(message = "chua nhap gender")
    private String gender;
}
