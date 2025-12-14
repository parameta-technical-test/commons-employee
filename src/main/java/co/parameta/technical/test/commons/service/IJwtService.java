package co.parameta.technical.test.commons.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Service interface for JWT token management.
 * <p>
 * Defines operations for generating, validating, and extracting
 * information from JSON Web Tokens used in application authentication
 * and authorization.
 */
public interface IJwtService {

    /**
     * Generates a JWT token for the given authenticated user.
     *
     * @param userDetails the authenticated user details
     * @return a signed JWT token
     */
    String getToken(UserDetails userDetails);

    /**
     * Extracts the username (subject) from the given JWT token.
     *
     * @param token the JWT token
     * @return the username contained in the token
     */
    String getUsernameFromToken(String token);

    /**
     * Validates the given JWT token against the provided user details.
     *
     * @param token the JWT token to validate
     * @param userDetails the user details to compare against
     * @return {@code true} if the token is valid, otherwise {@code false}
     */
    boolean isTokenValid(String token, UserDetails userDetails);

    /**
     * Returns the remaining validity time of the token in milliseconds.
     *
     * @param token the JWT token
     * @return remaining time before expiration, in milliseconds
     */
    long getTimeRemainingMillis(String token);

    /**
     * Extracts the application-specific user code from the JWT token.
     *
     * @param token the JWT token
     * @return the user code stored in the token
     */
    String getCodeFromToken(String token);

    /**
     * Retrieves the raw JWT token from the current request Authorization header.
     *
     * @return the JWT token value
     */
    String getTokenFromHeader();

}
