package com.example.users.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@Entity
@Table(name = "user")
public class User extends AuditEntity {

    @NotNull(message = "Chua nhap name")
    @Size(max = 50, message = "vuot qua so ki tu")
    private String name;

    @NotNull(message = "chua nhap birthday")
    private Date birthday;


    @Pattern(message = "sai dinh dang phone", regexp = "^\\d{10}$")
    @Size(max = 10, message = "vuot qua so ki tu")
    private String phone;

    @Email(message = "sai dinh dang email", regexp = "^(.+)@(\\S+)$")
    @Size(max = 254, message = "vuot qua so ki tu")
    private String email;

    @Size(max = 254, message = "vuot qua so ki tu")
    private String address;

    @NotNull(message = "chua nhap gender")
    private String gender;

}
