package co.parameta.tecnical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "id",
        "names",
        "lastNames",
        "codeTypeDocument",
        "documentNumber",
        "dateOfBirth",
        "dateAffiliationCompany",
        "codePosition",
        "salary",
        "codeAdministratorUser",
        "dateCreate",
        "dateUpdate"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {

    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "names")
    private String names;

    @XmlElement(name = "last-names")
    private String lastNames;

    @XmlElement(name = "type-document")
    private TypeDocumentPojo codeTypeDocument;

    @XmlElement(name = "document-number")
    private String documentNumber;

    @XmlElement(name = "date-of-birth")
    private Date dateOfBirth;

    @XmlElement(name = "date-affiliation-company")
    private Date dateAffiliationCompany;

    @XmlElement(name = "position")
    private PositionPojo codePosition;

    @XmlElement(name = "salary")
    private BigDecimal salary;

    @XmlElement(name = "administrator-user")
    private AdministratorUserPojo codeAdministratorUser;

    @XmlElement(name = "date-create")
    private Date dateCreate;

    @XmlElement(name = "date-update")
    private Date dateUpdate;

}
