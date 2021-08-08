package com.jihani.country.controller;

import com.jihani.country.model.Country;
import com.jihani.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v2")
public class CountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public Country save(@RequestBody Country country){
        return countryService.save(country);
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public ResponseEntity<Country> fetchCountry(@RequestParam int id) {
        Country country= countryService.fetchCountry(id);
        if(country == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(country);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List fetchAllCountries() {
        return countryService.fetchAllCountries();
    }

    @RequestMapping(value = "/country", method = RequestMethod.PUT)
    public Country update(@RequestBody Country country){
        return countryService.update(country);
    }

    @RequestMapping(value = "/country", method = RequestMethod.DELETE)
    public String delete(@RequestParam int id){
       return countryService.delete(id);
    }
}
