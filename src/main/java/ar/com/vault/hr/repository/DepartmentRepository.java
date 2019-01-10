package ar.com.vault.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vault.hr.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    List<Department> getByLocationId(Long id);

}
