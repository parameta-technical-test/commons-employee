//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v4.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
//


package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.parameta.technical.test.soap.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactoryPojo {

    private static final QName _Employee_QNAME = new QName("http://parameta.co/technical/test/employee", "Employee");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.parameta.technical.test.soap.gen
     * 
     */
    public ObjectFactoryPojo() {
    }

    /**
     * Create an instance of {@link EmployeePojo }
     * 
     * @return
     *     the new instance of {@link EmployeePojo }
     */
    public EmployeePojo createEmployee() {
        return new EmployeePojo();
    }

    /**
     * Create an instance of {@link SaveEmployeeRequestPojo }
     * 
     * @return
     *     the new instance of {@link SaveEmployeeRequestPojo }
     */
    public SaveEmployeeRequestPojo createSaveEmployeeRequest() {
        return new SaveEmployeeRequestPojo();
    }

    /**
     * Create an instance of {@link EmployeeResponsePojo }
     * 
     * @return
     *     the new instance of {@link EmployeeResponsePojo }
     */
    public EmployeeResponsePojo createEmployeeResponse() {
        return new EmployeeResponsePojo();
    }

    /**
     * Create an instance of {@link EmployeeResponseTypePojo }
     * 
     * @return
     *     the new instance of {@link EmployeeResponseTypePojo }
     */
    public EmployeeResponseTypePojo createEmployeeResponseType() {
        return new EmployeeResponseTypePojo();
    }

    /**
     * Create an instance of {@link TypeDocumentPojo }
     * 
     * @return
     *     the new instance of {@link TypeDocumentPojo }
     */
    public TypeDocumentPojo createTypeDocument() {
        return new TypeDocumentPojo();
    }

    /**
     * Create an instance of {@link PositionPojo }
     * 
     * @return
     *     the new instance of {@link PositionPojo }
     */
    public PositionPojo createPosition() {
        return new PositionPojo();
    }

    /**
     * Create an instance of {@link AdministratorUserPojo }
     * 
     * @return
     *     the new instance of {@link AdministratorUserPojo }
     */
    public AdministratorUserPojo createAdministratorUser() {
        return new AdministratorUserPojo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeePojo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmployeePojo }{@code >}
     */
    @XmlElementDecl(namespace = "http://parameta.co/technical/test/employee", name = "Employee")
    public JAXBElement<EmployeePojo> createEmployee(EmployeePojo value) {
        return new JAXBElement<>(_Employee_QNAME, EmployeePojo.class, null, value);
    }

}
