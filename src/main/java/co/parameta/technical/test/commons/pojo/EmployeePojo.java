//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Clase Java para Employee complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="Employee">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="names" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="lastNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="typeDocument" type="{http://parameta.co/technical/test/employee}TypeDocument" minOccurs="0"/>
 *         <element name="documentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="dateAffiliationCompany" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="position" type="{http://parameta.co/technical/test/employee}Position" minOccurs="0"/>
 *         <element name="salary" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         <element name="administratorUser" type="{http://parameta.co/technical/test/employee}AdministratorUser" minOccurs="0"/>
 *         <element name="dateCreate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="dateUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Employee",
        propOrder = {
                "id","names","lastNames",
                "typeDocument",
                "documentNumber",
                "dateOfBirth","dateAffiliationCompany",
                "position",
                "salary",
                "administratorUser",
                "dateCreate","dateUpdate"
        }
)
@Data
public class EmployeePojo {

    protected Integer id;
    protected String names;
    protected String lastNames;
    @XmlElement(name="typeDocument", namespace="http://parameta.co/technical/test/employee")
    protected TypeDocumentPojo typeDocument;
    protected String documentNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAffiliationCompany;
    @XmlElement(name="position", namespace="http://parameta.co/technical/test/employee")
    protected PositionPojo position;
    protected BigDecimal salary;
    @XmlElement(name="administratorUser", namespace="http://parameta.co/technical/test/employee")
    protected AdministratorUserPojo administratorUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateUpdate;

}
