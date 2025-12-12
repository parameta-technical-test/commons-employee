package co.parameta.tecnical.test.commons.service.impl;

import co.parameta.tecnical.test.commons.dto.AdministratorUserDTO;
import co.parameta.tecnical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.tecnical.test.commons.dto.RespuestaGeneralDTO;
import co.parameta.tecnical.test.commons.repository.BlacklistTokenRepository;
import co.parameta.tecnical.test.commons.service.IJwtService;
import co.parameta.tecnical.test.commons.service.ITokenBlacklistService;
import co.parameta.tecnical.test.commons.util.mapper.BlacklistTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@RequiredArgsConstructor
@Service
public class TokenBlacklistService implements ITokenBlacklistService {

    private final BlacklistTokenRepository blacklistTokenRepository;

    private final BlacklistTokenMapper blacklistTokenMapper;

    private final IJwtService iJwtService;


    @Override
    public RespuestaGeneralDTO revokeToken(String token) {
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Null or empty token");
        }
        token = token.trim();
        if (token.toLowerCase().startsWith("bearer ")) {
            token = token.substring(7).trim();
        }

        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("Token malformatted after removal 'Bearer '");
        }
        BlacklistTokenDTO blacklistTokenDTO = new BlacklistTokenDTO();
        blacklistTokenDTO.setToken(token);
        AdministratorUserDTO administratorUser = new AdministratorUserDTO();
        administratorUser.setCode(iJwtService.getCodeFromToken(token));
        blacklistTokenDTO.setAdministratorUser(administratorUser);
        blacklistTokenRepository.save(blacklistTokenMapper.dtoToEntity(blacklistTokenDTO));

        return respuesta;
    }

    @Override
    public void cleanExpired(long expirationThresholdMillis) {
        blacklistTokenRepository.deleteAll();
    }
}
