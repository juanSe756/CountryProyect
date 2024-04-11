package com.springproyect.countryproyect.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproyect.countryproyect.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CountryService {
    Random random = new Random();
//    private final RestTemplate restTemplate;

    @Value("classpath:data/countries.json")
    private Resource countriesResource;

    private final ObjectMapper objectMapper = new ObjectMapper();
//    @Autowired
//    public CountryService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public Country getRandomCountry() {
        try {
            List<Country> countries = Arrays.asList(objectMapper.readValue(countriesResource.getFile(), Country[].class));
            if (!countries.isEmpty()) {
                int randomIndex = random.nextInt(countries.size());
                return countries.get(randomIndex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
