package co.parameta.technical.test.commons.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    String getToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    long getTimeRemainingMillis(String token);

    String getCodeFromToken(String token);

    String getTokenFromHeader();

}
