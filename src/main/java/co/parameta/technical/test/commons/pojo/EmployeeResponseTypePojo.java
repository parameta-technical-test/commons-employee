package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

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

    @XmlElement(name = "status", namespace = NS, required = true)
    protected String status;

    @XmlElement(name = "message", namespace = NS)
    protected String message;

    @XmlElement(name = "additionalEmployeeInformation", namespace = NS)
    protected AdditionalEmployeeInformationPojo additionalEmployeeInformation;
}
