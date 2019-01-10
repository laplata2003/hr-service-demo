package ar.com.vault.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
