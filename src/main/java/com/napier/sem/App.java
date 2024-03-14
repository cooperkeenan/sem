package com.napier.sem;

import java.util.List;
import java.util.ArrayList;

public class App {
    public List<Country> getCountriesByPopulation() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT country_name, population FROM countries ORDER BY population DESC";
        // Execute query, process results, and return a list of Country objects


        return countries; // This should return the 'countries' variable, not 'Country'
    }

    public boolean isListCorrectlyOrdered(List<Country> countries) {
        for (int i = 0; i < countries.size() - 1; i++) {
            if (countries.get(i).getPopulation() < countries.get(i + 1).getPopulation()) {
                return false; // The list is not in descending order
            }
        }
        return true; // The list is correctly ordered
    }
}

class Country {
    private String countryName;
    private int population;

    // Constructor
    public Country(String countryName, int population) {
        this.countryName = countryName;
        this.population = population;
    }

    // Getter methods
    public String getCountryName() {
        return countryName;
    }

    public int getPopulation() {
        return population;
    }

    // Setter methods as needed
}
