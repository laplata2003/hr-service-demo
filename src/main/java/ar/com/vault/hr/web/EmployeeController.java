package ar.com.vault.hr.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vault.hr.domain.Employee;
import ar.com.vault.hr.dto.EmployeeDto;
import ar.com.vault.hr.service.EmployeeService;

/**
 * REST API for Employees handling.
 * 
 * @author Gaston Napoli
 *
 */
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    EmployeeDto getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getBasicProfileById(id);
    }

    @GetMapping("/employees/{id}/details")
    Employee getDetailedEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getDetailedProfileById(id);
    }

    @PostMapping("/employees")
    Employee createNewEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }
    
    @GetMapping(value = "/employees")
    List<Employee> getAllEmployees(
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page, 
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            @RequestParam(value = "job_id", required = false) String jobId,
            @RequestParam(value = "manager_id", required = false, defaultValue = "-1") long managerId,
            @RequestParam(value = "last_name", required = false) String lastName) {
        return employeeService.findPaginated(page, size, jobId, managerId, lastName);
    }

}
