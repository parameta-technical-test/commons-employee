package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Data Transfer Object that represents a Groovy-based validation rule.
 * <p>
 * Each instance defines a dynamic validation script that can be
 * executed at runtime during employee validation processes.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScriptValidationDTO {

    /**
     * Unique code that identifies the validation rule.
     */
    private String code;

    /**
     * Groovy script source used to perform the validation logic.
     */
    private String groovieCode;

    /**
     * Date when the validation rule was created.
     */
    private Date dateCreate;

    /**
     * Date of the last update to the validation rule.
     */
    private Date dateUpdate;

    /**
     * Validation state flag.
     * <p>
     * Typically {@code 1} indicates active and {@code 0} inactive.
     */
    private int state;

}
