package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object that represents a document type.
 * <p>
 * Used to identify and describe the type of identification
 * document associated with an employee (e.g. CC, Passport).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeDocumentDTO {

    /**
     * Unique code that identifies the document type.
     */
    private String code;

    /**
     * Human-readable description of the document type.
     */
    private String description;
}
