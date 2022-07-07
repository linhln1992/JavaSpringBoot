package com.example.users.repository.roles;

import com.example.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryInterface extends JpaRepository<Role, Long> {
}
