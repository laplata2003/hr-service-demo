package ar.com.vault.hr.dto;

import javax.validation.constraints.NotNull;

import ar.com.vault.hr.validator.ValidDepartmentDto;
import lombok.Data;

/**
 * Narrowed version of Department used as a DTO.
 * 
 * @author Gaston Napoli
 *
 */
@Data
@ValidDepartmentDto
public class DepartmentDto {

    @NotNull
    private String name;

    @NotNull
    private Long locationId;
    
}
