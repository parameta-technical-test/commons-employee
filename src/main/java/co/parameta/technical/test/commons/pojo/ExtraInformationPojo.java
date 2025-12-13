package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "AdditionalEmployeeInformation",
        propOrder = {
                "years",
                "months",
                "days"
        }
)
@Data
public class ExtraInformationPojo {

    private Integer years;

    private Integer months;

    private Integer days;
}
