package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

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

    @XmlElement(name = "id", namespace = NS)
    protected Integer id;

    @XmlElement(name = "names", namespace = NS)
    protected String names;

    @XmlElement(name = "lastNames", namespace = NS)
    protected String lastNames;

    @XmlElement(name = "typeDocument", namespace = NS)
    protected TypeDocumentPojo typeDocument;

    @XmlElement(name = "documentNumber", namespace = NS)
    protected String documentNumber;

    @XmlElement(name = "dateOfBirth", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;

    @XmlElement(name = "dateAffiliationCompany", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAffiliationCompany;

    @XmlElement(name = "position", namespace = NS)
    protected PositionPojo position;

    @XmlElement(name = "salary", namespace = NS)
    protected BigDecimal salary;

    @XmlElement(name = "administratorUser", namespace = NS)
    protected AdministratorUserPojo administratorUser;

    @XmlElement(name = "dateCreate", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreate;

    @XmlElement(name = "dateUpdate", namespace = NS)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateUpdate;
}
