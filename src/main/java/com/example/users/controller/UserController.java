package com.example.users.controller;

import com.example.users.entity.UserEntity;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/listUser")
    public List<UserEntity> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public UserEntity getUserById(@PathVariable(name = "userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public UserEntity createUser(@Valid @RequestBody UserEntity user, BindingResult bindingResult) throws BindException {
        if(!bindingResult.getAllErrors().isEmpty()){
            throw new BindException(bindingResult);
        }
        return userService.createUser(user);
    }

    @PutMapping("/user/{userId}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable(name = "userId") Long id) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long id) {
        userService.deleteUser(id);
    }
}
