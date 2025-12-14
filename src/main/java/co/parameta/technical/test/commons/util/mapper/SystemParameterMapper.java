package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.SystemParameterDTO;
import co.parameta.technical.test.commons.entity.SystemParameterEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link SystemParameterEntity}
 * and {@link SystemParameterDTO}.
 * <p>
 * This mapper is used to transform system configuration parameters stored
 * in the database into DTOs consumed by the application logic, and vice versa.
 * <p>
 * Implemented automatically by MapStruct and managed as a Spring bean.
 */
@Mapper(componentModel = "spring")
public interface SystemParameterMapper extends BaseMapper<SystemParameterEntity, SystemParameterDTO> {

}
