package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "code",
        "description"
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PositionPojo {

    @XmlElement(name = "code")
    private String code;

    @XmlElement(name = "description")
    private String description;

}
