package ar.com.vault.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
