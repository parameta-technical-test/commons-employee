package co.parameta.technical.test.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "blacklist_token", schema = "technical_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistTokenEntity {
    @Id
    @Column(name = "token", length = 150)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_administrator_user", nullable = false)
    private AdministratorUserEntity administratorUser;

    @Column(name = "date_create")
    private Date dateCreate;
}
