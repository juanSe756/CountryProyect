package com.springproyect.countryproyect.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproyect.countryproyect.models.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@Service
public class CountryService {

    private final Random random = new Random();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("classpath:data/countries.json")
    private Resource countriesResource;

    public Country getRandomCountry() {
        try (InputStream inputStream = countriesResource.getInputStream()) {
            Country[] countries = objectMapper.readValue(inputStream, Country[].class);
            if (countries.length > 0) {
                int randomIndex = random.nextInt(countries.length);
                return countries[randomIndex];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
