package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO representing a blacklisted JWT token.
 * <p>
 * This object is used to track revoked or invalidated tokens,
 * typically during logout or security enforcement processes.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistTokenDTO {

    /**
     * JWT token value that has been revoked.
     */
    private String token;

    /**
     * Administrator user associated with the revoked token.
     */
    private AdministratorUserDTO administratorUser;

    /**
     * Date when the token was added to the blacklist.
     */
    private Date dateCreate;
}
