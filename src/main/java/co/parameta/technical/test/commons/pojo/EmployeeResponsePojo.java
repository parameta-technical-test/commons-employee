package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP root element that wraps the employee operation response.
 * <p>
 * This class represents the main SOAP response structure returned
 * by employee-related operations such as save, update, or validation.
 * It contains the detailed response information inside
 * {@link EmployeeResponseTypePojo}.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "response" })
@XmlRootElement(name = "EmployeeResponse", namespace = NS)
@Data
public class EmployeeResponsePojo {

    /**
     * Detailed response information including status, message,
     * and optional additional employee data.
     */
    @XmlElement(name = "response", namespace = NS, required = true)
    protected EmployeeResponseTypePojo response;
}
