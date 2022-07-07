package com.example.users.controller;

import com.example.users.model.User;
import com.example.users.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/listUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable(name = "userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user, BindingResult bindingResult) throws BindException {
        if(!bindingResult.getAllErrors().isEmpty()){
            throw new BindException(bindingResult);
        }
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public Long deleteUser(@PathVariable(name = "userId") Long id) {
        userService.deleteUserById(id);
        return id;
    }

    @PutMapping("/update")
    public User updateUser(@Valid @RequestBody User user, BindingResult bindingResult) throws BindException  {
        if(!bindingResult.getAllErrors().isEmpty()){
            throw new BindException(bindingResult);
        }
        return userService.updateUser(user);
    }
}
