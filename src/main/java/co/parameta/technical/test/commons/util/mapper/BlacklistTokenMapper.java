package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.BlacklistTokenDTO;
import co.parameta.technical.test.commons.entity.BlacklistTokenEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link BlacklistTokenEntity}
 * and {@link BlacklistTokenDTO}.
 * <p>
 * This mapper is used to transform blacklist token persistence entities
 * into DTOs and vice versa, supporting token revocation and validation
 * processes within the security layer.
 * <p>
 * Implemented automatically by MapStruct and managed as a Spring bean.
 */
@Mapper(componentModel = "spring")
public interface BlacklistTokenMapper extends BaseMapper<BlacklistTokenEntity, BlacklistTokenDTO> {

}
