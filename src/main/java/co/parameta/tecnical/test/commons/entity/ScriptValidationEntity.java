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

    @Id
    @Column(name = "code", length = 5)
    private String code;

    @Column(name = "description", nullable = false)
    private String groovie_code;

    @Column(name = "date_create", nullable = false)
    private Date dateCreate;

    @Column(name = "date_update", nullable = false)
    private Date dateUpdate;

}
