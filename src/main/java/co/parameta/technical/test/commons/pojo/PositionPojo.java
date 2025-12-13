package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

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


    @XmlElement(name = "code", namespace = NS)
    protected String code;

    @XmlElement(name = "description", namespace = NS)
    protected String description;
}
