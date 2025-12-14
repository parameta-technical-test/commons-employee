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
 * JPA entity that represents a configurable system parameter.
 * <p>
 * System parameters are used to control dynamic behavior of the application
 * such as feature toggles, email settings, PDF handling, and validation rules,
 * without requiring code changes.
 */
@Entity
@Table(name = "system_parameter", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemParameterEntity {

    /**
     * Unique identifier of the system parameter.
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * Parameter name used as a functional key.
     */
    @Column(name = "name")
    private String name;

    /**
     * Parameter value or configuration content.
     */
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * User or process that created the parameter.
     */
    @Column(name = "creator", nullable = false)
    private String creator;

    /**
     * Creation timestamp of the parameter.
     */
    @Column(name = "date_create")
    private Date dateCreate;

    /**
     * Last update timestamp of the parameter.
     */
    @Column(name = "date_update")
    private Date dateUpdate;

}
