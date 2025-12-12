package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.ScriptValidationDTO;
import co.parameta.technical.test.commons.entity.ScriptValidationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScriptValidationMapper  extends BaseMapper<ScriptValidationEntity, ScriptValidationDTO>{




}
