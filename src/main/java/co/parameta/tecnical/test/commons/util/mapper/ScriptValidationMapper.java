package co.parameta.tecnical.test.commons.util.mapper;

import co.parameta.tecnical.test.commons.dto.ScriptValidationDTO;
import co.parameta.tecnical.test.commons.entity.ScriptValidationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScriptValidationMapper {

    ScriptValidationDTO entityToDto(ScriptValidationEntity scriptValidation);

    ScriptValidationEntity dtoToEntity(ScriptValidationDTO scriptValidation);


}
