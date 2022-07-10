package com.example.users.controller;

import com.example.users.entity.CountryEntity;
import com.example.users.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @PostMapping("/create")
    public CountryEntity createCountry(@RequestBody  CountryEntity countryEntity){
        return countryService.createCountry(countryEntity);
    }

}
