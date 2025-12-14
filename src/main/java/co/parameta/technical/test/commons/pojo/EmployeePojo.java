package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP POJO that represents an employee.
 * <p>
 * This class is used as part of the SOAP contract for creating,
 * updating, and retrieving employee information. It maps directly
 * to the employee domain model and follows JAXB standards.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Employee",
        propOrder = {
                "id",
                "names",
                "lastNames",
                "typeDocument",
                "documentNumber",
                "dateOfBirth",
                "dateAffiliationCompany",
                "position",
                "salary",
                "administratorUser",
                "dateCreate",
                "dateUpdate"
        }
)
@Data
public class EmployeePojo {

    /**
     * Unique identifier of the employee.
     */
    @XmlElement(name = "id", namespace = NS)
    protected Integer id;

    /**
     * Employee first names.
     */
    @XmlElement(name = "names", namespace = NS)
    protected String names;

    /**
     * Employee last names.
     */
    @XmlElement(name = "lastNames", namespace = NS)
    protected String lastNames;

    /**
     * Type of identification document.
     */
    @XmlElement(name = "typeDocument", namespace = NS)
    protected TypeDocumentPojo typeDocument;

    /**
     * Identification document number.
     */
    @XmlElement(name = "documentNumber", namespace = NS)
    protected String documentNumber;

    /**
     * Employee date of birth.
     */
    @XmlElement(name = "dateOfBirth", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;

    /**
     * Date when the employee joined the company.
     */
    @XmlElement(name = "dateAffiliationCompany", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAffiliationCompany;

    /**
     * Employee job position.
     */
    @XmlElement(name = "position", namespace = NS)
    protected PositionPojo position;

    /**
     * Employee salary.
     */
    @XmlElement(name = "salary", namespace = NS)
    protected BigDecimal salary;

    /**
     * Administrator user responsible for the operation.
     */
    @XmlElement(name = "administratorUser", namespace = NS)
    protected AdministratorUserPojo administratorUser;

    /**
     * Record creation date.
     */
    @XmlElement(name = "dateCreate", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreate;

    /**
     * Record last update date.
     */
    @XmlElement(name = "dateUpdate", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateUpdate;
}
