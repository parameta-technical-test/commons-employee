package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.ScriptValidationDTO;
import co.parameta.technical.test.commons.entity.ScriptValidationEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link ScriptValidationEntity}
 * and {@link ScriptValidationDTO}.
 * <p>
 * This mapper is responsible for transforming validation scripts stored
 * in the database into DTOs used during dynamic Groovy validation execution,
 * and vice versa.
 * <p>
 * Implemented automatically by MapStruct and registered as a Spring bean.
 */
@Mapper(componentModel = "spring")
public interface ScriptValidationMapper extends BaseMapper<ScriptValidationEntity, ScriptValidationDTO> {

}
