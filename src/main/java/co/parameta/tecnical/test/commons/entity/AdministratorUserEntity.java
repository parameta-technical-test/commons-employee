package co.parameta.tecnical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administrator_user", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorUserEntity {

    @Id
    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "password_encoder", length = 100, nullable = false)
    private String passwordEncoder;

}
