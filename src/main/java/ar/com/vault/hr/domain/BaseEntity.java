package ar.com.vault.hr.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Base class for entities. It includes all the common attributes amount the entities. 
 * It can be used for shared auditing attributes, for example creation date, last update date, 
 * updated by, and so on.
 * 
 * @author Gaston Napoli
 *
 */
@MappedSuperclass
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "version"})
public abstract class BaseEntity {

    /**
     * For optimistic locking.
     */
    @Version
    @Column(name = "VERSION")
    @JsonIgnore
    private Long version;
    
}

