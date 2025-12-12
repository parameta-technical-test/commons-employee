package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Integer id;

    private String names;
    private String lastNames;

    private String codeTypeDocument;
    private String documentNumber;

    private Date dateOfBirth;
    private Date dateAffiliationCompany;

    private String codePosition;
    private BigDecimal salary;

    private String codeAdministratorUser;

    private Date dateCreate;
    private Date dateUpdate;
}