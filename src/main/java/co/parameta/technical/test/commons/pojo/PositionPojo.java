package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP JAXB representation of an employee position.
 * <p>
 * This class maps the position information exchanged through
 * the SOAP service, including the position code and its
 * descriptive name.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Position",
        propOrder = {
                "code",
                "description"
        }
)
@Data
public class PositionPojo {

    /**
     * Unique code that identifies the position.
     */
    @XmlElement(name = "code", namespace = NS)
    protected String code;

    /**
     * Human-readable description of the position.
     */
    @XmlElement(name = "description", namespace = NS)
    protected String description;
}
