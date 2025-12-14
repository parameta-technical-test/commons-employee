package co.parameta.technical.test.commons.service.impl;

import co.parameta.technical.test.commons.dto.AdministratorUserDTO;
import co.parameta.technical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.technical.test.commons.dto.ResponseGeneralDTO;
import co.parameta.technical.test.commons.repository.BlacklistTokenRepository;
import co.parameta.technical.test.commons.service.IJwtService;
import co.parameta.technical.test.commons.service.ITokenBlacklistService;
import co.parameta.technical.test.commons.util.mapper.BlacklistTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Service implementation responsible for managing JWT token revocation.
 * <p>
 * This service allows tokens to be blacklisted in order to invalidate
 * active sessions (logout support) and provides cleanup functionality
 * for expired tokens.
 */
@RequiredArgsConstructor
@Service
public class TokenBlacklistService implements ITokenBlacklistService {

    /**
     * Repository used to persist and query blacklisted tokens.
     */
    private final BlacklistTokenRepository blacklistTokenRepository;

    /**
     * Mapper used to convert DTOs to blacklist token entities.
     */
    private final BlacklistTokenMapper blacklistTokenMapper;

    /**
     * JWT service used to extract user information from tokens.
     */
    private final IJwtService iJwtService;

    /**
     * Revokes a JWT token by storing it in the blacklist.
     * <p>
     * The method:
     * <ul>
     *   <li>Validates token format</li>
     *   <li>Removes {@code Bearer} prefix if present</li>
     *   <li>Associates the token with the authenticated user</li>
     *   <li>Persists the token in the blacklist</li>
     * </ul>
     *
     * @param token JWT token or Authorization header value
     * @return generic response indicating successful revocation
     * @throws RuntimeException if the token is null, empty, or malformed
     */
    @Override
    public ResponseGeneralDTO revokeToken(String token) {
        ResponseGeneralDTO response = new ResponseGeneralDTO();

        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Null or empty token");
        }

        token = token.trim();
        if (token.toLowerCase().startsWith("bearer ")) {
            token = token.substring(7).trim();
        }

        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Token malformed after removing 'Bearer ' prefix");
        }

        BlacklistTokenDTO blacklistTokenDTO = new BlacklistTokenDTO();
        blacklistTokenDTO.setToken(token);

        AdministratorUserDTO administratorUser = new AdministratorUserDTO();
        administratorUser.setCode(iJwtService.getCodeFromToken(token));
        blacklistTokenDTO.setAdministratorUser(administratorUser);

        blacklistTokenRepository.save(
                blacklistTokenMapper.toEntity(blacklistTokenDTO)
        );

        return response;
    }

    /**
     * Cleans expired tokens from the blacklist.
     * <p>
     * Currently removes all blacklisted tokens. This method
     * can be extended to support selective cleanup based on
     * expiration thresholds.
     *
     * @param expirationThresholdMillis expiration time threshold in milliseconds
     */
    @Override
    public void cleanExpired(long expirationThresholdMillis) {
        blacklistTokenRepository.deleteAll();
    }
}
