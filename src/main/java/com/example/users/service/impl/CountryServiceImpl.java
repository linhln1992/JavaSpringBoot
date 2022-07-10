package com.example.users.service.impl;

import com.example.users.entity.CountryEntity;
import com.example.users.repository.CountryRepository;
import com.example.users.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryEntity createCountry(CountryEntity countryEntity) {
        return countryRepository.save(countryEntity);
    }
}
