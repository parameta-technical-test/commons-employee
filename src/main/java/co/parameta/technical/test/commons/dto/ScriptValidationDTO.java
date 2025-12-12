package co.parameta.technical.test.commons.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScriptValidationDTO {

    private String code;

    private String groovieCode;

    private Date dateCreate;

    private Date dateUpdate;

    private int state;

}

