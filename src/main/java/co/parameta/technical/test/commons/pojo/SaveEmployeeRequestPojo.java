package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP request wrapper used to save or update an employee.
 * <p>
 * This class represents the root element of the SOAP request
 * sent to the employee service, containing the employee data
 * to be persisted or updated.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "employee"
        }
)
@XmlRootElement(
        name = "SaveEmployeeRequest",
        namespace = NS
)
@Data
public class SaveEmployeeRequestPojo {

    /**
     * Employee information to be saved or updated.
     */
    @XmlElement(
            name = "employee",
            namespace = NS,
            required = true
    )
    protected EmployeePojo employee;
}
