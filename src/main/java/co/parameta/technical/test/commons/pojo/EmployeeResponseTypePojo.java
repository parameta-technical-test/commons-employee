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
    "employee"
})
public class EmployeeResponseTypePojo {

    @XmlElement(required = true)
    protected String status;
    protected String message;
    protected EmployeePojo employee;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define el valor de la propiedad message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtiene el valor de la propiedad employee.
     * 
     * @return
     *     possible object is
     *     {@link EmployeePojo }
     *     
     */
    public EmployeePojo getEmployee() {
        return employee;
    }

    /**
     * Define el valor de la propiedad employee.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeePojo }
     *     
     */
    public void setEmployee(EmployeePojo value) {
        this.employee = value;
    }

}
