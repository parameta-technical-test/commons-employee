//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

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
@XmlType(name = "Employee", propOrder = {
    "id",
    "names",
    "lastNames",
    "typeDocument",
    "documentNumber",
    "dateOfBirth",
    "dateAffiliationCompany",
    "position",
    "salary",
    "administratorUser",
    "dateCreate",
    "dateUpdate"
})
public class EmployeePojo {

    protected Integer id;
    protected String names;
    protected String lastNames;
    protected TypeDocumentPojo typeDocumentPojo;
    protected String documentNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAffiliationCompany;
    protected PositionPojo positionPojo;
    protected BigDecimal salary;
    protected AdministratorUserPojo administratorUserPojo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateUpdate;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad names.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNames() {
        return names;
    }

    /**
     * Define el valor de la propiedad names.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNames(String value) {
        this.names = value;
    }

    /**
     * Obtiene el valor de la propiedad lastNames.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastNames() {
        return lastNames;
    }

    /**
     * Define el valor de la propiedad lastNames.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastNames(String value) {
        this.lastNames = value;
    }

    /**
     * Obtiene el valor de la propiedad typeDocument.
     * 
     * @return
     *     possible object is
     *     {@link TypeDocumentPojo }
     *     
     */
    public TypeDocumentPojo getTypeDocument() {
        return typeDocumentPojo;
    }

    /**
     * Define el valor de la propiedad typeDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDocumentPojo }
     *     
     */
    public void setTypeDocument(TypeDocumentPojo value) {
        this.typeDocumentPojo = value;
    }

    /**
     * Obtiene el valor de la propiedad documentNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Define el valor de la propiedad documentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad dateOfBirth.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Define el valor de la propiedad dateOfBirth.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Obtiene el valor de la propiedad dateAffiliationCompany.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAffiliationCompany() {
        return dateAffiliationCompany;
    }

    /**
     * Define el valor de la propiedad dateAffiliationCompany.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAffiliationCompany(XMLGregorianCalendar value) {
        this.dateAffiliationCompany = value;
    }

    /**
     * Obtiene el valor de la propiedad position.
     * 
     * @return
     *     possible object is
     *     {@link PositionPojo }
     *     
     */
    public PositionPojo getPosition() {
        return positionPojo;
    }

    /**
     * Define el valor de la propiedad position.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionPojo }
     *     
     */
    public void setPosition(PositionPojo value) {
        this.positionPojo = value;
    }

    /**
     * Obtiene el valor de la propiedad salary.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Define el valor de la propiedad salary.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalary(BigDecimal value) {
        this.salary = value;
    }

    /**
     * Obtiene el valor de la propiedad administratorUser.
     * 
     * @return
     *     possible object is
     *     {@link AdministratorUserPojo }
     *     
     */
    public AdministratorUserPojo getAdministratorUser() {
        return administratorUserPojo;
    }

    /**
     * Define el valor de la propiedad administratorUser.
     * 
     * @param value
     *     allowed object is
     *     {@link AdministratorUserPojo }
     *     
     */
    public void setAdministratorUser(AdministratorUserPojo value) {
        this.administratorUserPojo = value;
    }

    /**
     * Obtiene el valor de la propiedad dateCreate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreate() {
        return dateCreate;
    }

    /**
     * Define el valor de la propiedad dateCreate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreate(XMLGregorianCalendar value) {
        this.dateCreate = value;
    }

    /**
     * Obtiene el valor de la propiedad dateUpdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateUpdate() {
        return dateUpdate;
    }

    /**
     * Define el valor de la propiedad dateUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateUpdate(XMLGregorianCalendar value) {
        this.dateUpdate = value;
    }

}
