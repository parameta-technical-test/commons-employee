package co.parameta.technical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * JPA entity that represents an employee within the system.
 * <p>
 * Stores personal, contractual, and administrative information,
 * including references to document type, position, and the user
 * responsible for the registration.
 */
@Entity
@Table(name = "employee", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    /**
     * Primary key identifier of the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Employee first names.
     */
    @Column(name = "names", length = 80)
    private String names;

    /**
     * Employee last names.
     */
    @Column(name = "last_names", length = 80)
    private String lastNames;

    /**
     * Document type associated with the employee.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_type_document", nullable = false)
    private TypeDocumentEntity typeDocument;

    /**
     * Employee document number.
     */
    @Column(name = "document_number", length = 20, nullable = false)
    private String documentNumber;

    /**
     * Employee date of birth.
     */
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    /**
     * Date when the employee was affiliated with the company.
     */
    @Column(name = "date_affiliation_company", nullable = false)
    private Date dateAffiliationCompany;

    /**
     * Position or role assigned to the employee.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_position", nullable = false)
    private PositionEntity position;

    /**
     * Employee salary.
     */
    @Column(name = "salary", precision = 10, scale = 2, nullable = false)
    private BigDecimal salary;

    /**
     * Administrator user who registered or manages the employee.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_administrator_user", nullable = false)
    private AdministratorUserEntity administratorUser;

    /**
     * Record creation date.
     */
    @Column(name = "date_create")
    private Date dateCreate;

    /**
     * Record last update date.
     */
    @Column(name = "date_update")
    private Date dateUpdate;

    /**
     * Storage location (S3 key) of the generated employee PDF report.
     */
    @Column(name = "storage_location_report")
    private String storageLocationReport;

}
