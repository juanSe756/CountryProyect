package com.springproyect.countryproyect.controllers;

import com.springproyect.countryproyect.models.Country;
import com.springproyect.countryproyect.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;
    private String host;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
        try {
            InetAddress address = InetAddress.getLocalHost();
            host = "http://" + address.getHostAddress();
            System.out.println("Running at "+host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/generate")
    public Country getRandomCountry() {
        return countryService.getRandomCountry();
    }
}