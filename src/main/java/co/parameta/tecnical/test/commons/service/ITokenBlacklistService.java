package co.parameta.tecnical.test.commons.service;

import co.parameta.tecnical.test.commons.dto.RespuestaGeneralDTO;

import java.io.IOException;

public interface ITokenBlacklistService {

    RespuestaGeneralDTO revokeToken(String token);

    void cleanExpired(long expirationThresholdMillis) throws IOException;

}
