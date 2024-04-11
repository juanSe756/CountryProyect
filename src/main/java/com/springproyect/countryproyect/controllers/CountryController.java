package com.springproyect.countryproyect.controllers;

import com.springproyect.countryproyect.models.Country;
import com.springproyect.countryproyect.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/")
    public Country getRandomCountry() {
        return countryService.getRandomCountry();
    }
}