package co.parameta.technical.test.commons.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SystemParameterDTO {

    private Integer id;

    private String name;

    private String content;

    private String creator;

    private Date dateCreate;

    private Date dateUpdate;

}
