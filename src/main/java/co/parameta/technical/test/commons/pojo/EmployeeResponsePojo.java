//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="response" type="{http://parameta.co/technical/test/employee}EmployeeResponseType"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "EmployeeResponse")
public class EmployeeResponsePojo {

    @XmlElement(required = true)
    protected EmployeeResponseTypePojo response;

    /**
     * Obtiene el valor de la propiedad response.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeResponseTypePojo }
     *     
     */
    public EmployeeResponseTypePojo getResponse() {
        return response;
    }

    /**
     * Define el valor de la propiedad response.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeResponseTypePojo }
     *     
     */
    public void setResponse(EmployeeResponseTypePojo value) {
        this.response = value;
    }

}
