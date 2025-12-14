package co.parameta.technical.test.commons.service.impl;

import co.parameta.technical.test.commons.dto.AdministratorUserDTO;
import co.parameta.technical.test.commons.repository.BlacklistTokenRepository;
import co.parameta.technical.test.commons.service.IJwtService;
import co.parameta.technical.test.commons.util.enums.TokenStatusEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * JWT service implementation responsible for token generation,
 * validation, and claim extraction.
 * <p>
 * This service handles:
 * <ul>
 *   <li>JWT creation with custom claims</li>
 *   <li>Token validation and expiration checks</li>
 *   <li>Extraction of user information from tokens</li>
 *   <li>Integration with token blacklist for revocation support</li>
 * </ul>
 */
@Data
@Log4j2
@RequiredArgsConstructor
@Service
public class JwtService implements IJwtService {

    /**
     * Secret key used to sign and validate JWT tokens.
     */
    @Value("${jwt.secret}")
    private String secretKey;


    /**
     * Repository used to verify if a token has been revoked.
     */
    private final BlacklistTokenRepository blacklistTokenRepository;


    /**
     * Generates a JWT token for the given authenticated user.
     * <p>
     * The token includes standard claims and custom claims such as
     * user email and internal user code.
     *
     * @param userDetails authenticated user details
     * @return generated JWT token
     */
    @Override
    public String getToken(UserDetails userDetails) {
        Map<String, Object> additionalClaims = new HashMap<>();
        long expirationTimeInMillis = 24 * 60 * 60 * 1000;
        if (userDetails instanceof AdministratorUserDTO administratorUser) {
            additionalClaims.put("sub", administratorUser.getEmail());
            additionalClaims.put("code", administratorUser.getCode());
        }
        return buildToken(additionalClaims, userDetails, expirationTimeInMillis);
    }

    /**
     * Extracts the username (subject) from the given JWT token.
     *
     * @param token JWT token
     * @return username contained in the token
     */
    @Override
    public String getUsernameFromToken(String token) {
        String claims = getClaims(token, Claims::getSubject);
        return claims;
    }

    /**
     * Validates the token against the given user details and checks expiration.
     *
     * @param token JWT token
     * @param userDetails authenticated user details
     * @return {@code true} if the token is valid, {@code false} otherwise
     */
    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * Returns the remaining validity time of the token in milliseconds.
     *
     * @param token JWT token
     * @return remaining time in milliseconds, or {@code 0} if invalid
     */
    @Override
    public long getTimeRemainingMillis(String token) {
        Date expiration = getExpiration(token);
        return expiration != null
                ? expiration.getTime()
                : 0L;
    }

    /**
     * Extracts the internal user code from the JWT custom claims.
     *
     * @param token JWT token
     * @return user code stored in the token
     */
    @Override
    public String getCodeFromToken(String token) {
        return getClaims(token, claims -> claims.get("code", String.class));
    }

    /**
     * Retrieves the JWT token from the current HTTP request header.
     * <p>
     * The token is extracted from the {@code Authorization} header
     * using the {@code Bearer} scheme.
     *
     * @return raw JWT token or {@code null} if not present
     */
    @Override
    public String getTokenFromHeader() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr == null) {
            return null;
        }
        HttpServletRequest request = attr.getRequest();
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7).trim();
        }
        return null;
    }

    /**
     * Generic helper method to extract a specific claim.
     *
     * @param token JWT token
     * @param claimsResolver resolver function
     * @param <T> return type
     * @return resolved claim value
     */
    private <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    /**
     * Validates the current token status considering:
     * <ul>
     *   <li>Token format</li>
     *   <li>Signature validity</li>
     *   <li>Expiration</li>
     *   <li>Blacklist revocation</li>
     * </ul>
     *
     * @param token Authorization header value
     * @return token validation status
     */
    public TokenStatusEnum validateTokenStatus(String token) {
        if (token == null) {
            return TokenStatusEnum.INVALID;
        }
        if (!StringUtils.hasText(token) && !token.startsWith("Bearer ")) {
            return TokenStatusEnum.INVALID;
        }
        token =  token.substring(7).trim().replaceAll("\\s+", "");
        if(blacklistTokenRepository.existsByToken(token)){
            return TokenStatusEnum.INVALID;
        }
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
            return TokenStatusEnum.VALID;
        } catch (ExpiredJwtException ex) {
            log.error(ex.getMessage());
            return TokenStatusEnum.EXPIRED;
        } catch (JwtException | IllegalArgumentException ex) {
            log.error(ex.getMessage());
            return TokenStatusEnum.INVALID;
        }
    }

    /**
     * Builds and signs a JWT token with the provided claims and expiration.
     *
     * @param extraClaims custom claims
     * @param user authenticated user
     * @param expirationTimeInMillis expiration time in milliseconds
     * @return signed JWT token
     */
    private String buildToken(Map<String, Object> extraClaims, UserDetails user, long expirationTimeInMillis) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));

        Instant now = Instant.now();
        Instant expiration = now.plusMillis(expirationTimeInMillis);

        return Jwts.builder()
                .claims(extraClaims)
                .subject(user.getUsername())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .signWith(key, Jwts.SIG.HS512)
                .compact();
    }

    /**
     * Checks whether the token has expired.
     *
     * @param token JWT token
     * @return true if expired
     */
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    /**
     * Extracts all claims from the JWT token.
     *
     * @param token JWT token
     * @return parsed token claims
     */
    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
