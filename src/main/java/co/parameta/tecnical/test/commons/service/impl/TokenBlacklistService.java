package co.parameta.tecnical.test.commons.service.impl;

import co.parameta.tecnical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.tecnical.test.commons.dto.RespuestaGeneralDTO;
import co.parameta.tecnical.test.commons.repository.BlacklistTokenRepository;
import co.parameta.tecnical.test.commons.service.ITokenBlacklistService;
import co.parameta.tecnical.test.commons.util.mapper.BlacklistTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenBlacklistService implements ITokenBlacklistService {

    private final Set<String> revokedTokens = Collections.synchronizedSet(new HashSet<>());

    private final BlacklistTokenRepository blacklistTokenRepository;

    private final BlacklistTokenMapper blacklistTokenMapper;

    @Override
    public RespuestaGeneralDTO revokeToken(String token) {
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Token null o vacío");
        }
        token = token.trim();
        if (token.toLowerCase().startsWith("bearer ")) {
            token = token.substring(7).trim();
        }

        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Token mal formateado tras quitar 'Bearer '");
        }
        BlacklistTokenDTO blacklistTokenDTO = new BlacklistTokenDTO();
        blacklistTokenDTO.setToken(token);

        blacklistTokenRepository.save(blacklistTokenMapper.dtoToEntity(blacklistTokenDTO));

        return respuesta;
    }

    @Override
    public boolean isTokenRevoked(String token) {
        return revokedTokens.contains(token);
    }

    @Override
    public void cleanExpired(long expirationThresholdMillis) {
        revokedTokens.clear();
        blacklistTokenRepository.deleteAll();
    }
}
