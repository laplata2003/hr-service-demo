package ar.com.vault.hr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * It represents the departments existing in the company.
 * 
 * @author Gaston Napoli
 *
 */
@Entity
@Table(name = "DEPARTMENTS")
@Setter
@Getter
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Department extends BaseEntity {

    /**
     * Autogenerated 4-digit number ID. 
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "DEPARTMENT_ID", nullable = false, length = 4)
    @Max(999)
    private Long id;

    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    @Size(max = 40)
    @NotNull
    @NonNull
    private String name;

    /**
     * Many departments can be settled in a location.
     */
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    @NotNull
    @NonNull
    private Location location;

    /**
     * A department has a manager.
     */
    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    @JsonIgnoreProperties({ "department", "job", "manager", "jobHistories" })
    private Employee manager;
    
    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
}
