package ar.com.vault.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
