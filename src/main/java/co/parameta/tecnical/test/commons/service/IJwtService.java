package co.parameta.tecnical.test.commons.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    String getToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    long getTiempoRestanteMillis(String token);

    String getCodigoFromToken(String token);

    String obtenerTokenDelHeader();

}
