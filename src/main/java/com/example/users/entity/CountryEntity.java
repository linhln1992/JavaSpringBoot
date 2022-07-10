package com.example.users.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity extends AuditEntity{
    private String countryCode;

    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<UserEntity> users = new ArrayList<>();

}
