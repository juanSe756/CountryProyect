package com.springproyect.countryproyect.controllers;

import com.springproyect.countryproyect.models.Country;
import com.springproyect.countryproyect.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/generate")
    public Country getRandomCountry() {
        return countryService.getRandomCountry();
    }
}