package co.parameta.technical.test.commons.service;

import co.parameta.technical.test.commons.dto.ResponseGeneralDTO;

import java.io.IOException;

public interface ITokenBlacklistService {

    ResponseGeneralDTO revokeToken(String token);

    void cleanExpired(long expirationThresholdMillis) throws IOException;

}
