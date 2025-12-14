package co.parameta.technical.test.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * JPA entity that represents a dynamic validation rule executed using Groovy.
 * <p>
 * Each record stores a Groovy script used to validate employee data at runtime.
 * The execution and activation of the script are controlled by its state.
 */
@Entity
@Table(name = "script_validation", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScriptValidationEntity {

    /**
     * Unique identifier of the validation script.
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * Business code that identifies the validation rule.
     */
    @Column(name = "code")
    private String code;

    /**
     * Groovy script content executed during validation.
     */
    @Column(name = "groovie_code", nullable = false)
    private String groovieCode;

    /**
     * Creation timestamp of the validation rule.
     */
    @Column(name = "date_create", nullable = false)
    private Date dateCreate;

    /**
     * Last update timestamp of the validation rule.
     */
    @Column(name = "date_update", nullable = false)
    private Date dateUpdate;

    /**
     * Indicates whether the script is active (1) or inactive (0).
     */
    @Column(name = "state")
    private int state;

}
