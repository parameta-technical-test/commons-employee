package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.technical.test.commons.entity.BlacklistTokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlacklistTokenMapper  extends BaseMapper<BlacklistTokenEntity, BlacklistTokenDTO>{


}
