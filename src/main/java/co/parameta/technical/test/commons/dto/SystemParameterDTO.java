package co.parameta.technical.test.commons.dto;

import lombok.Data;

import java.util.Date;

/**
 * Data Transfer Object that represents a system configuration parameter.
 * <p>
 * System parameters are used to control dynamic and configurable
 * behavior across the application without code changes.
 */
@Data
public class SystemParameterDTO {

    /**
     * Unique identifier of the system parameter.
     */
    private Integer id;

    /**
     * Logical name of the parameter.
     * <p>
     * Used as a key to retrieve configuration values.
     */
    private String name;

    /**
     * Value or content associated with the parameter.
     */
    private String content;

    /**
     * User or system that created the parameter.
     */
    private String creator;

    /**
     * Date when the parameter was created.
     */
    private Date dateCreate;

    /**
     * Date of the last update to the parameter.
     */
    private Date dateUpdate;

}
