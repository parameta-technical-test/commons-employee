//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;


/**
 * <p>Clase Java para EmployeeResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="EmployeeResponseType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="employee" type="{http://parameta.co/technical/test/employee}Employee" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeResponseType", propOrder = {
    "status",
    "message",
    "additionalEmployeeInformation"
})
@Data
public class EmployeeResponseTypePojo {

    @XmlElement(required = true)
    protected String status;
    protected String message;
    protected AdditionalEmployeeInformationPojo additionalEmployeeInformation;


}
