package com.example.users.service;

import com.example.users.entity.UserEntity;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import static java.util.Collections.emptyMap;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id){
        return userRepository.getById(id);
    }

    public UserEntity createUser(UserEntity user) throws BindException {
        BindingResult bindingResult = new MapBindingResult(emptyMap(), "");
        System.out.println("======throw=====");
        if(!bindingResult.getAllErrors().isEmpty()){
            throw new BindException(bindingResult);
        }
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user){
        UserEntity oldUser = userRepository.getById(user.getId());
        oldUser.setName(user.getName());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setPhone(user.getPhone());
        oldUser.setEmail(user.getEmail());
        oldUser.setAddress(user.getAddress());
        oldUser.setGender(user.getGender());
        return userRepository.save(oldUser);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
