package com.springproyect.countryproyect.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    private String name;
    private String capital;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("capital")
    public String getCapital() {
        return capital;
    }
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}


