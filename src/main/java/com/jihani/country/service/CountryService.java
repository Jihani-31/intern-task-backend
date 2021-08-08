package com.jihani.country.service;

import com.jihani.country.model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);
    Country fetchCountry(int id);
    List<Country> fetchAllCountries();
    Country update(Country country);
    String delete(int id);

}
