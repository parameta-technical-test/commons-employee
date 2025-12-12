package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "administratorUser")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "code"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorUserPojo {

    @XmlElement(name = "code")
    private String code;

}