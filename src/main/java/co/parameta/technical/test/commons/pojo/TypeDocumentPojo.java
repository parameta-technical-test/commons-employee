package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import static co.parameta.technical.test.commons.util.constantes.Constants.NS;

/**
 * SOAP representation of a document type.
 * <p>
 * This class defines the document identification type
 * associated with an employee, including its code and
 * descriptive name.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "TypeDocument",
        propOrder = {
                "code",
                "description"
        }
)
@Data
public class TypeDocumentPojo {

    /**
     * Unique code that identifies the document type.
     */
    @XmlElement(name = "code", namespace = NS)
    protected String code;

    /**
     * Human-readable description of the document type.
     */
    @XmlElement(name = "description", namespace = NS)
    protected String description;
}
