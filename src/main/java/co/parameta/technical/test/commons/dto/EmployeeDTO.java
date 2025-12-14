package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object that represents an employee.
 * <p>
 * This DTO is used across REST and SOAP layers to transport
 * employee information, including personal data, employment
 * details, and related metadata.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    /**
     * Unique identifier of the employee.
     */
    private Integer id;

    /**
     * Employee first names.
     */
    private String names;

    /**
     * Employee last names.
     */
    private String lastNames;

    /**
     * Document type information (code and description).
     */
    private TypeDocumentDTO typeDocument;

    /**
     * Employee document number.
     */
    private String documentNumber;

    /**
     * Employee date of birth.
     */
    private Date dateOfBirth;

    /**
     * Date when the employee was affiliated with the company.
     */
    private Date dateAffiliationCompany;

    /**
     * Employee job position.
     */
    private PositionDTO position;

    /**
     * Employee salary.
     */
    private BigDecimal salary;

    /**
     * Administrator user associated with the employee record.
     */
    private AdministratorUserDTO administratorUser;

    /**
     * Record creation timestamp.
     */
    private Date dateCreate;

    /**
     * Record last update timestamp.
     */
    private Date dateUpdate;

    /**
     * Storage location (S3 key) of the generated employee PDF report.
     */
    private String storageLocationReport;
}
