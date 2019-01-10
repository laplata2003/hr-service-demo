package ar.com.vault.hr.service;

import java.util.List;

import ar.com.vault.hr.domain.Employee;
import ar.com.vault.hr.dto.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto getBasicProfileById(long id);

    Employee getDetailedProfileById(long id);

    Employee save(Employee employee);
    
    Employee update(Employee employee);

    void deleteById(Long id);
    
    Double getAverageSalaryByLocationId(Long locationId);

    List<Employee> findPaginated(int page, int size, String jobId, long managerId, String lastName);

}
