package com.example.users.service.users;

import com.example.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    public List<User> getAllUser();

    public Optional<User> getUserById(Long id);

    public User createUser(User user);

    public User updateUser(User user);

    public Long deleteUserById(long id);
}
