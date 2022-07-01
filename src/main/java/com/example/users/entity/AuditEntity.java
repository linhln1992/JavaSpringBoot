package com.example.users.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class AuditEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recordVersion;
    private String createdId;
    private Date createdAt;
    private Date modifiedAt;
    private String modifiedId;
    private Integer deleteFlag;
}
