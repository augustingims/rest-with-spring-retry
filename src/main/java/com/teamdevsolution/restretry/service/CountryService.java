package com.teamdevsolution.restretry.service;

import com.teamdevsolution.restretry.domain.Country;
import com.teamdevsolution.restretry.exception.CountryNotFoundException;
import com.teamdevsolution.restretry.exception.TypeOneException;
import com.teamdevsolution.restretry.exception.TypeTwoException;
import com.teamdevsolution.restretry.repository.CountryRepository;
import com.teamdevsolution.restretry.web.rest.CountryRessource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryRessource.class);
    private static int COUNTER = 0;
    private static Long COUNT = 5L;

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Retryable(value = {TypeOneException.class, TypeTwoException.class}, maxAttempts = 4, backoff = @Backoff(2000))
    public String retryWhenException() throws TypeOneException, TypeTwoException {
        COUNTER++;
        LOGGER.info("COUNTER = " + COUNTER);
        if(COUNTER == 1)
            throw new TypeOneException();
        else if(COUNTER == 2)
            throw new TypeTwoException();
        else
            throw new RuntimeException();
    }

    @Retryable(value = { CountryNotFoundException.class }, maxAttempts = 2, backoff = @Backoff(2000))
    public Country getCountry(Long id) throws CountryNotFoundException {
        COUNTER++;
        LOGGER.info("COUNTER = " + COUNTER);
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()){
            return  country.get();
        }
        throw new CountryNotFoundException("Country not found");
    }

    @Retryable(value = { CountryNotFoundException.class }, maxAttempts = 2, backoff = @Backoff(2000))
    public Country retryWhenCountries() throws CountryNotFoundException {
        COUNT--;
        LOGGER.info("COUNT = " + COUNT);
        Optional<Country> country = countryRepository.findById(COUNT);
        if(country.isPresent()){
            return  country.get();
        }
        throw new CountryNotFoundException("Country not found");
    }

    @Recover
    public String recover(Throwable t) {
        LOGGER.info("CountryService.recover");
        return "Error Class :: " + t.getClass().getName();
    }
}
