package com.example.users.service.impl;

import com.example.users.converter.UserConverter;
import com.example.users.dto.UserDTO;
import com.example.users.entity.CountryEntity;
import com.example.users.entity.UserEntity;
import com.example.users.repository.CountryRepository;
import com.example.users.repository.UserRepository;
import com.example.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        CountryEntity countryEntity = countryRepository.findOneByCountryCode(userDTO.getCountryCode());
        UserEntity userEntity = userConverter.toEntity(userDTO);
        userEntity.setCountry(countryEntity);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
