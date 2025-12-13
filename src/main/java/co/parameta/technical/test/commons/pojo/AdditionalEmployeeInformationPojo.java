package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AdditionalEmployeeInformationPojo",
        propOrder = {
                "timeLinkedToCompany",
                "currentAgeEmployee"
        }
)
@Data
public class AdditionalEmployeeInformationPojo {

    @XmlElement(name = "timeLinkedToCompany")
    protected ExtraInformationPojo timeLinkedToCompany;

    @XmlElement(name = "currentAgeEmployee")
    protected ExtraInformationPojo currentAgeEmployee;
}
