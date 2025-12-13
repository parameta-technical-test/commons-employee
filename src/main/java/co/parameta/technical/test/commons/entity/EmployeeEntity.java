package co.parameta.technical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "names", length = 80)
    private String names;

    @Column(name = "last_names", length = 80)
    private String lastNames;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_type_document", nullable = false)
    private TypeDocumentEntity typeDocument;

    @Column(name = "document_number", length = 20, nullable = false)
    private String documentNumber;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "date_affiliation_company", nullable = false)
    private Date dateAffiliationCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_position", nullable = false)
    private PositionEntity position;

    @Column(name = "salary", precision = 10, scale = 2, nullable = false)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_administrator_user", nullable = false)
    private AdministratorUserEntity administratorUser;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "storage_location_report")
    private String storageLocationReport;

}
