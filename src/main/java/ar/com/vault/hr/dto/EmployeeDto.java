package ar.com.vault.hr.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Projection with a basic profice of the entity Employee, to be used as a DTO.
 * 
 * @author Gaston Napoli
 *
 */
public interface EmployeeDto {

    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    @Value("#{target.phoneNumber?: ''}")
    String getPhoneNumber();

    LocalDate getHireDate();

    @Value("#{target.salary?: 0.0}")
    double getSalary();

    @Value("#{target.department?.name ?: ''}")
    String getDepartmentName();

    @Value("#{target.manager?.firstName ?: null}")
    @JsonIgnore
    String getManagerFirstName();

    @Value("#{target.manager?.lastName ?: null}")
    @JsonIgnore
    String getManagerLastName();

    default String getManagerName() {

        StringBuilder buffer = new StringBuilder();

        if (getManagerFirstName() == null) {
            if (getManagerLastName() == null) {
                buffer.append("");
            }
        } else {
            buffer.append(getManagerFirstName());
            if (getManagerLastName() != null) {
                buffer.append(' ').append(getManagerLastName());
            }
        }

        return buffer.toString();

    }

}
