package ar.com.vault.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.JobHistory;
import ar.com.vault.hr.domain.JobHistoryId;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {

    List<JobHistory> findByEmployeeId(Long id);
    
}
