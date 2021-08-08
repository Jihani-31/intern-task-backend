package com.jihani.country.service;

import com.jihani.country.model.Country;
import com.jihani.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country save(Country country){
        return countryRepository.save(country);
    }

    @Override
    public Country fetchCountry(int id){
        Optional<Country> country=countryRepository.findById(id);
        return country.orElse(null);
    }

    @Override
    public List<Country> fetchAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country update(Country country) {
        Country oldCountry = null;
        Optional<Country> optionalCountry=countryRepository.findById(country.getId());
        if (optionalCountry.isPresent()){
            oldCountry=optionalCountry.get();
            oldCountry.setCountryName(country.getCountryName());
            oldCountry.setContinent(country.getContinent());
            oldCountry.setCapital(country.getCapital());
            oldCountry.setCurrency(country.getCurrency());
            oldCountry.setPhoneCode(country.getPhoneCode());
            countryRepository.save(oldCountry);
        }
        else {
           return new Country();
        }
        return oldCountry;
    }

    @Override
    public String delete(int id) {
        countryRepository.deleteById(id);
        return "country deleted";
    }


}
