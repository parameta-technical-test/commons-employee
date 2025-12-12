package co.parameta.technical.test.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionEntity {

    @Id
    @Column(name = "code", length = 5)
    private String code;

    @Column(name = "description", length = 150, nullable = false)
    private String description;

}
