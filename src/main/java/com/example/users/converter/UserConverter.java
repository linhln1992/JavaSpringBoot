package com.example.users.converter;

import com.example.users.dto.UserDTO;
import com.example.users.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setBirthday(dto.getBirthday());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setBirthday(entity.getBirthday());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setGender(entity.getGender());

        return dto;
    }
}
