package com.example.users.service;

import com.example.users.dto.UserDTO;
import com.example.users.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUser();
    UserEntity getUserById(Long id);
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    void deleteUser(long id);
}
