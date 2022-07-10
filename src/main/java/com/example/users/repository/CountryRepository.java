package com.example.users.repository;

import com.example.users.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    CountryEntity findOneByCountryCode(String countryCode);
}
