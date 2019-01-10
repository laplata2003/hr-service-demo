package ar.com.vault.hr.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * It represents the work history for each employee.
 * 
 * @author Gaston Napoli
 *
 */
@Entity
@Table(name = "JOB_HISTORY")
@Setter
@Getter
public class JobHistory  extends BaseEntity {

    @EmbeddedId
    private JobHistoryId id; 

    @MapsId("employeeId")
    @JoinColumn(name = "EMPLOYEE_ID", insertable=false, updatable=false, nullable=false)
    @ManyToOne
    @JsonBackReference
    private Employee employee;

    @Column(name = "END_DATE")
    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate endDate;
    
    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    @JsonIgnoreProperties({ "manager", "location" })
    private Department department;
  
    @OneToOne
    @JoinColumn(name = "JOB_ID")
    @JsonIgnoreProperties({ "minimumSalary", "maximumSalary" })
    private Job job;
    
}

