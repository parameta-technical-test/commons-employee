package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP POJO that represents an administrator user.
 * <p>
 * This object is used within SOAP requests and responses to
 * identify the administrator responsible for the operation.
 * Sensitive information such as passwords is intentionally excluded.
 */
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

    /**
     * Unique code that identifies the administrator user.
     */
    @XmlElement(name = "code", namespace = NS)
    protected String code;

    /**
     * Email address of the administrator user.
     */
    @XmlElement(name = "email", namespace = NS)
    private String email;

}
