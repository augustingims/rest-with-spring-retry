package com.teamdevsolution.restretry.web.rest;

import com.teamdevsolution.restretry.domain.Country;
import com.teamdevsolution.restretry.exception.CountryNotFoundException;
import com.teamdevsolution.restretry.exception.TypeOneException;
import com.teamdevsolution.restretry.exception.TypeTwoException;
import com.teamdevsolution.restretry.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRessource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryRessource.class);
    private static int COUNTER = 0;

    private final CountryService countryService;

    public CountryRessource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable Long id) throws CountryNotFoundException {
        return countryService.getCountry(id);
    }

    @GetMapping("/retryWhenCountries")
    public Country retryWhenCountries() throws CountryNotFoundException {
        return countryService.retryWhenCountries();
    }

    @GetMapping("/retries")
    public String retryWhenException() throws TypeOneException, TypeTwoException {
        return countryService.retryWhenException();
    }

}

