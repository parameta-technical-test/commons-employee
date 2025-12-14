package co.parameta.technical.test.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA entity that represents an employee position or role.
 * <p>
 * Defines the functional role assigned to an employee within the company
 * and is referenced by employee records.
 */
@Entity
@Table(name = "position", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionEntity {

    /**
     * Unique code that identifies the position.
     */
    @Id
    @Column(name = "code", length = 5)
    private String code;

    /**
     * Human-readable description of the position.
     */
    @Column(name = "description", length = 150, nullable = false)
    private String description;

}
