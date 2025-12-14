package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP data structure that represents a time span expressed
 * in years, months, and days.
 * <p>
 * This type is commonly used to expose calculated values such as
 * employee age or time linked to the company.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ExtraInformation",
        propOrder = { "years", "months", "days" }
)
@Data
public class ExtraInformationPojo {

    /**
     * Number of complete years.
     */
    @XmlElement(name = "years", namespace = NS)
    private Integer years;

    /**
     * Number of complete months.
     */
    @XmlElement(name = "months", namespace = NS)
    private Integer months;

    /**
     * Number of remaining days.
     */
    @XmlElement(name = "days", namespace = NS)
    private Integer days;
}
