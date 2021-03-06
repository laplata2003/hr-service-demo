package ar.com.vault.hr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * It represents countries in a region.
 * 
 * @author Gaston Napoli
 *
 */
@Entity
@Table(name = "COUNTRIES")
@Setter
@Getter
public class Country extends BaseEntity {

    /**
     * Non autogenerated/identity value, it has to be set on insert.
     */
    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    @Size(min = 2, max = 2)
    private String id;

    @Column(name = "COUNTRY_NAME", length = 40)
    @Size(max = 40)
    private String name;

    /**
     * Many countries belong to a region.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    @NotNull
    private Region region;

}