package ar.com.vault.hr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import ar.com.vault.hr.domain.Employee;
import ar.com.vault.hr.dto.EmployeeDto;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee> {
    
    Optional<EmployeeDto> findProjectedById(Long id);
    
    List<Employee> findByDepartmentLocationId(@Param("id") Long id);
    
    @Query(value = "SELECT avg(e.salary) from Employee e where e.department.location.id = :locationId")
    Optional<Double> getAverageSalaryByLocationId(@Param("locationId")  Long locationId);
 
}
