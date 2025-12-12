package co.parameta.tecnical.test.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "script_validation", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScriptValidationEntity {

    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "description", nullable = false)
    private String groovieCode;

    @Column(name = "date_create", nullable = false)
    private Date dateCreate;

    @Column(name = "date_update", nullable = false)
    private Date dateUpdate;

    @Column(name = "state")
    private int state;

}
