package co.parameta.technical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA entity that represents an administrator user of the system.
 * <p>
 * This entity is used for authentication and authorization purposes
 * within the application.
 */
@Entity
@Table(name = "administrator_user", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorUserEntity {

    /**
     * Unique identifier of the administrator user.
     * <p>
     * Used as a logical code instead of a numeric ID.
     */
    @Id
    @Column(name = "code", length = 20)
    private String code;

    /**
     * Email address of the administrator user.
     * <p>
     * Used as the username during authentication.
     */
    @Column(name = "email", length = 80, nullable = false)
    private String email;

    /**
     * Encrypted password of the administrator user.
     */
    @Column(name = "password_encoder", length = 100, nullable = false)
    private String passwordEncoder;

}
