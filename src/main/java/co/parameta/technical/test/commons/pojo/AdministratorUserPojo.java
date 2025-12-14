package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AdministratorUser",
        propOrder = {
                "code",
                "email"
        }
)
@Data
public class AdministratorUserPojo {

    @XmlElement(name = "code", namespace = NS)
    protected String code;

    @XmlElement(name = "email", namespace = NS)
    private String email;

}
