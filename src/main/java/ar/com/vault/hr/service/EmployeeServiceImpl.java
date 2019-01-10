package ar.com.vault.hr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import ar.com.vault.hr.domain.Employee;
import ar.com.vault.hr.domain.QEmployee;
import ar.com.vault.hr.dto.EmployeeDto;
import ar.com.vault.hr.exception.EmployeeNotFoundException;
import ar.com.vault.hr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto getBasicProfileById(long id) {
        return employeeRepository.findProjectedById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee getDetailedProfileById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Long id = employee.getId();

        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeToUpdate.copyFrom(employee);
        final Employee updatedEmployee = employeeRepository.save(employeeToUpdate);

        return updatedEmployee;
    }

    @Override
    public Double getAverageSalaryByLocationId(Long locationId) {
        return employeeRepository.getAverageSalaryByLocationId(locationId).orElse(0.0);
    }

    @Override
    public List<Employee> findPaginated(int page, int size, String jobId, long managerId, String lastName) {

        // If 'page'is no defined, all rows are fetched.
        Pageable pageable = page == -1 ? Pageable.unpaged() : PageRequest.of(page, size);

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        // Filters
        if (lastName != null && !lastName.isEmpty()) {
            booleanBuilder.and(QEmployee.employee.lastName.containsIgnoreCase(lastName));
        }

        if (jobId != null) {
            booleanBuilder.and(QEmployee.employee.job.id.containsIgnoreCase(jobId));
        }

        if (managerId != -1) {
            booleanBuilder.and(QEmployee.employee.manager.id.eq(managerId));
        }

        Page<Employee> employeesPage = employeeRepository.findAll(booleanBuilder.getValue(), pageable);
        List<Employee> unsortedEmployees = employeesPage.getContent();

        return unsortedEmployees.stream().sorted().collect(Collectors.toList());

    }

}
