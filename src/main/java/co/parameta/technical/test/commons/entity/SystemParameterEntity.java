package co.parameta.technical.test.commons.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "system_parameter", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemParameterEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creator", nullable = false)
    private String creator;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;


}
