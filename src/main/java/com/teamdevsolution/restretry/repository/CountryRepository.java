package com.teamdevsolution.restretry.repository;

import com.teamdevsolution.restretry.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country,Long> {
    Optional<Country> findById(Long id);
}
