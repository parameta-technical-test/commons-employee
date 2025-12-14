package co.parameta.technical.test.commons.pojo;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;

/**
 * JAXB Object Factory for the SOAP employee schema.
 * <p>
 * This class provides factory methods to programmatically create
 * instances of JAXB-bound classes and XML elements defined in the
 * employee SOAP namespace.
 * <p>
 * It is mainly used by the JAXB runtime during marshalling and
 * unmarshalling processes.
 */
@XmlRegistry
public class ObjectFactoryPojo {

    /**
     * QName for the root Employee element.
     */
    private static final QName _Employee_QNAME =
            new QName("http://parameta.co/technical/test/employee", "Employee");

    /**
     * Default constructor.
     */
    public ObjectFactoryPojo() {
    }

    /**
     * Creates a new {@link EmployeePojo} instance.
     *
     * @return a new EmployeePojo
     */
    public EmployeePojo createEmployee() {
        return new EmployeePojo();
    }

    /**
     * Creates a new {@link SaveEmployeeRequestPojo} instance.
     *
     * @return a new SaveEmployeeRequestPojo
     */
    public SaveEmployeeRequestPojo createSaveEmployeeRequest() {
        return new SaveEmployeeRequestPojo();
    }

    /**
     * Creates a new {@link EmployeeResponsePojo} instance.
     *
     * @return a new EmployeeResponsePojo
     */
    public EmployeeResponsePojo createEmployeeResponse() {
        return new EmployeeResponsePojo();
    }

    /**
     * Creates a new {@link EmployeeResponseTypePojo} instance.
     *
     * @return a new EmployeeResponseTypePojo
     */
    public EmployeeResponseTypePojo createEmployeeResponseType() {
        return new EmployeeResponseTypePojo();
    }

    /**
     * Creates a new {@link TypeDocumentPojo} instance.
     *
     * @return a new TypeDocumentPojo
     */
    public TypeDocumentPojo createTypeDocument() {
        return new TypeDocumentPojo();
    }

    /**
     * Creates a new {@link PositionPojo} instance.
     *
     * @return a new PositionPojo
     */
    public PositionPojo createPosition() {
        return new PositionPojo();
    }

    /**
     * Creates a new {@link AdministratorUserPojo} instance.
     *
     * @return a new AdministratorUserPojo
     */
    public AdministratorUserPojo createAdministratorUser() {
        return new AdministratorUserPojo();
    }

    /**
     * Creates a {@link JAXBElement} wrapper for {@link EmployeePojo}.
     * <p>
     * This method is required to bind the Java object to the
     * corresponding XML root element.
     *
     * @param value the EmployeePojo value
     * @return a JAXBElement wrapping the EmployeePojo
     */
    @XmlElementDecl(
            namespace = "http://parameta.co/technical/test/employee",
            name = "Employee"
    )
    public JAXBElement<EmployeePojo> createEmployee(EmployeePojo value) {
        return new JAXBElement<>(_Employee_QNAME, EmployeePojo.class, null, value);
    }
}
