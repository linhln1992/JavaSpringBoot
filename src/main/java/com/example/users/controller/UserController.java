package com.example.users.controller;

import com.example.users.converter.UserConverter;
import com.example.users.dto.UserDTO;
import com.example.users.entity.UserEntity;
import com.example.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/listUser")
    public List<UserEntity> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public UserEntity getUserById(@PathVariable(name = "userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
//        if(!bindingResult.getAllErrors().isEmpty()){
//            throw new BindException(bindingResult);
//        }
        return userService.createUser(userDTO);
    }

    @PutMapping("/user/{userId}")
    public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable(name = "userId") Long id) {
//        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long id) {
        userService.deleteUser(id);
    }
}
