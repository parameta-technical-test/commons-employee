package co.parameta.technical.test.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA entity that represents a type of identification document.
 * <p>
 * This entity is used to standardize employee identification data
 * and is referenced by employees through a relational association.
 */
@Entity
@Table(name = "type_document", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDocumentEntity {

    /**
     * Unique code that identifies the document type (e.g. CC, PAS).
     */
    @Id
    @Column(name = "code", length = 5)
    private String code;

    /**
     * Human-readable description of the document type.
     */
    @Column(name = "description", length = 150, nullable = false)
    private String description;

}
