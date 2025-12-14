package co.parameta.technical.test.commons.service;

import co.parameta.technical.test.commons.dto.ResponseGeneralDTO;

import java.io.IOException;

/**
 * Service interface for managing revoked JWT tokens.
 * <p>
 * Provides operations to invalidate tokens (logout) and
 * periodically clean expired tokens from the blacklist.
 */
public interface ITokenBlacklistService {

    /**
     * Revokes the given JWT token by adding it to the blacklist.
     * <p>
     * Once revoked, the token can no longer be used for authentication.
     *
     * @param token the JWT token to revoke
     * @return a response containing the operation result
     */
    ResponseGeneralDTO revokeToken(String token);

    /**
     * Removes expired tokens from the blacklist based on
     * the provided expiration threshold.
     *
     * @param expirationThresholdMillis expiration time threshold in milliseconds
     * @throws IOException if an error occurs during the cleanup process
     */
    void cleanExpired(long expirationThresholdMillis) throws IOException;

}
