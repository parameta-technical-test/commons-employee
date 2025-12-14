package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP response type that contains the result of an employee operation.
 * <p>
 * This object holds the execution status, a descriptive message,
 * and optional additional employee information when the operation
 * completes successfully.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "EmployeeResponseType",
        propOrder = {
                "status",
                "message",
                "additionalEmployeeInformation"
        }
)
@Data
public class EmployeeResponseTypePojo {

    /**
     * Operation status value (e.g. SUCCESS, INTERNAL_ERROR).
     */
    @XmlElement(name = "status", namespace = NS, required = true)
    protected String status;

    /**
     * Human-readable message describing the operation result.
     */
    @XmlElement(name = "message", namespace = NS)
    protected String message;

    /**
     * Optional additional employee information returned
     * when the operation is successful.
     */
    @XmlElement(name = "additionalEmployeeInformation", namespace = NS)
    protected AdditionalEmployeeInformationPojo additionalEmployeeInformation;
}
