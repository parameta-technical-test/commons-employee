package co.parameta.tecnical.test.commons.service.impl;

import co.parameta.tecnical.test.commons.dto.AdministratorUserDTO;
import co.parameta.tecnical.test.commons.service.IJwtService;
import co.parameta.tecnical.test.commons.service.ITokenBlacklistService;
import co.parameta.tecnical.test.commons.util.enums.TokenStatusEnum;
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

@Data
@Log4j2
@RequiredArgsConstructor
@Service
public class JwtService implements IJwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private final ITokenBlacklistService iTokenBlacklistService;


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

    @Override
    public String getUsernameFromToken(String token) {
        String claims = getClaims(token, Claims::getSubject);
        return claims;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public long getTimeRemainingMillis(String token) {
        Date expiration = getExpiration(token);
        return expiration != null
                ? expiration.getTime()
                : 0L;
    }

    @Override
    public String getCodeFromToken(String token) {
        return getClaims(token, claims -> claims.get("code", String.class));
    }

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

    private <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public TokenStatusEnum validateTokenStatus(String token) {
        if (token == null) {
            return TokenStatusEnum.INVALID;
        }
        if (!StringUtils.hasText(token) && !token.startsWith("Bearer ")) {
            return TokenStatusEnum.INVALID;
        }
        token =  token.substring(7).trim().replaceAll("\\s+", "");
        if(iTokenBlacklistService.isTokenRevoked(token)){
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



}
