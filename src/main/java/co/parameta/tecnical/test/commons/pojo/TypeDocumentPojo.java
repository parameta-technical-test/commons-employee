package co.parameta.tecnical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "type-document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "code",
        "description"
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeDocumentPojo {

    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "description")
    private String description;

}
