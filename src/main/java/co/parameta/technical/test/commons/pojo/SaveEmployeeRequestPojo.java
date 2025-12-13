package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

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

    @XmlElement(
            name = "employee",
            namespace = NS,
            required = true
    )
    protected EmployeePojo employee;
}
