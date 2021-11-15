package com.example.travelnotewebservice.services;

import com.example.travelnotewebservice.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

}
