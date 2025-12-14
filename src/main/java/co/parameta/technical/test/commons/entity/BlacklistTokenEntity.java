package co.parameta.technical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * JPA entity that represents a blacklisted JWT token.
 * <p>
 * Tokens stored in this table are considered invalid and cannot be
 * used for authentication (e.g. after logout).
 */
@Entity
@Table(name = "blacklist_token", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistTokenEntity {

    /**
     * JWT token value that has been revoked.
     */
    @Id
    @Column(name = "token", length = 150)
    private String token;

    /**
     * Administrator user associated with the revoked token.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_administrator_user", nullable = false)
    private AdministratorUserEntity administratorUser;

    /**
     * Date when the token was added to the blacklist.
     */
    @Column(name = "date_create")
    private Date dateCreate;
}
