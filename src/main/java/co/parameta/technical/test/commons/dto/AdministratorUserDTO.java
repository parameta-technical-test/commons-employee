package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object that represents an administrator user.
 * <p>
 * This DTO is used across authentication, authorization, and
 * security-related processes, including JWT generation and
 * Spring Security user details mapping.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorUserDTO {

    /**
     * Unique administrator user code.
     */
    private String code;

    /**
     * Administrator email used as username for authentication.
     */
    private String email;

    /**
     * Encrypted password stored using a secure hashing algorithm.
     */
    private String passwordEncoder;
}
