package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object that represents an employee position.
 * <p>
 * This DTO is used to transfer position-related information
 * such as code and description between application layers.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {

    /**
     * Unique code that identifies the position.
     */
    private String code;

    /**
     * Human-readable description of the position.
     */
    private String description;
}
