package ar.com.vault.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.Job;

public interface JobRepository extends JpaRepository<Job, String> {

}
