package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.SystemParameterDTO;
import co.parameta.technical.test.commons.entity.SystemParameterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SystemParameterMapper extends BaseMapper<SystemParameterEntity, SystemParameterDTO>{

}
