package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ExtraInformation",
        propOrder = { "years", "months", "days" }
)
@Data
public class ExtraInformationPojo {

    @XmlElement(name = "years", namespace = NS)
    private Integer years;

    @XmlElement(name = "months", namespace = NS)
    private Integer months;

    @XmlElement(name = "days", namespace = NS)
    private Integer days;
}
