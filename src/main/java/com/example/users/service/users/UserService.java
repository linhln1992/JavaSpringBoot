package com.example.users.service.users;

import com.example.users.model.User;
import com.example.users.repository.users.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    UserRepositoryInterface userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User oldUser = userRepository.getById(user.getId());
        oldUser.setName(user.getName());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setPhone(user.getPhone());
        oldUser.setEmail(user.getEmail());
        oldUser.setAddress(user.getAddress());
        oldUser.setGender(user.getGender());
        return userRepository.save(oldUser);
    }

    @Override
    public Long deleteUserById(long id) {
        userRepository.deleteById(id);
        return id;
    }
}
