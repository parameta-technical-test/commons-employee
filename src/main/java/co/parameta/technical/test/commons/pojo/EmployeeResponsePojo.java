package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "response" })
@XmlRootElement(name = "EmployeeResponse", namespace = NS)
@Data
public class EmployeeResponsePojo {


    @XmlElement(name = "response", namespace = NS, required = true)
    protected EmployeeResponseTypePojo response;
}
