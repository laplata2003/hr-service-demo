package ar.com.vault.hr.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.vault.hr.dto.DepartmentDto;
import ar.com.vault.hr.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

/**
 * DepartmentDto validator. It uses as input the current day of the month and the average salary of the employees on each 
 * department within a given location (location ID).
 * 
 * @author Gaston Napoli
 *
 */
@Slf4j
public class DepartmentValidator implements ConstraintValidator<ValidDepartmentDto, DepartmentDto> {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initialize(ValidDepartmentDto constraintAnnotation) {

    }

    @Override
    public boolean isValid(DepartmentDto value, ConstraintValidatorContext context) {

        Double averageSalary = employeeService.getAverageSalaryByLocationId(value.getLocationId());
        int dayOfMonth = LocalDate.now().getDayOfMonth();

        log.info("Dia del mes: " + dayOfMonth);
        log.info("Salario promedio: " + averageSalary);

        if ((averageSalary > 1000.0 && dayOfMonth - 14 <= 0) || (dayOfMonth - 15 >= 0 && averageSalary > 1500)) {
            return false;
        }

        return true;
    }

}
