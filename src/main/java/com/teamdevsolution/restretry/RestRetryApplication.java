package com.teamdevsolution.restretry;

import com.teamdevsolution.restretry.domain.Country;
import com.teamdevsolution.restretry.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RestRetryApplication  implements CommandLineRunner{

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestRetryApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Country country = new Country("Cameroun","CM");
		countryRepository.save(country);
		country = new Country("Senegal","SG");
		countryRepository.save(country);
	}
}
