package ar.com.vault.hr.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * It represents the JobHistory entity's composite PK.
 * 
 * @author Gaston Napoli
 *
 */
@Embeddable
@Setter
@Getter
public class JobHistoryId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2192583255264310208L;

    @Column(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    private String employeeId;

    @Column(name = "START_DATE", nullable = false)
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

}
