package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP POJO that represents additional calculated information of an employee.
 * <p>
 * This object is used as part of the SOAP response to expose
 * derived data such as the employee's current age and the time
 * linked to the company.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AdditionalEmployeeInformation",
        propOrder = {
                "timeLinkedToCompany",
                "currentAgeEmployee"
        }
)
@Data
public class AdditionalEmployeeInformationPojo {

    /**
     * Represents the amount of time the employee has been linked to the company.
     * It is usually calculated based on the affiliation date.
     */
    @XmlElement(name = "timeLinkedToCompany", namespace = NS)
    protected ExtraInformationPojo timeLinkedToCompany;

    /**
     * Represents the current age of the employee calculated from the date of birth.
     */
    @XmlElement(name = "currentAgeEmployee", namespace = NS)
    protected ExtraInformationPojo currentAgeEmployee;
}
