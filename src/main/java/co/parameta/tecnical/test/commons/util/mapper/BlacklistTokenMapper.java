package co.parameta.tecnical.test.commons.util.mapper;

import co.parameta.tecnical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.tecnical.test.commons.entity.BlacklistTokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlacklistTokenMapper {

    BlacklistTokenDTO entityToDto(BlacklistTokenEntity blacklistTokenEntity);

    BlacklistTokenEntity dtoToEntity(BlacklistTokenDTO blacklistTokenDTO);

}
