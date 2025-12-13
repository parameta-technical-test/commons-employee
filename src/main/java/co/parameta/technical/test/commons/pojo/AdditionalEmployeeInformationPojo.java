package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AdditionalEmployeeInformation",
        propOrder = {
                "timeLinkedToCompany",
                "currentAgeEmployee"
        }
)
@Data
public class AdditionalEmployeeInformationPojo {


    @XmlElement(name = "timeLinkedToCompany", namespace = NS)
    protected ExtraInformationPojo timeLinkedToCompany;

    @XmlElement(name = "currentAgeEmployee", namespace = NS)
    protected ExtraInformationPojo currentAgeEmployee;
}
