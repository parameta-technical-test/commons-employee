package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.AdministratorUserDTO;
import co.parameta.technical.test.commons.entity.AdministratorUserEntity;
import org.mapstruct.Mapper;

/**
 * MapStruct mapper for converting between {@link AdministratorUserEntity}
 * and {@link AdministratorUserDTO}.
 * <p>
 * This mapper centralizes the transformation logic between persistence
 * and application layers, ensuring clean separation of concerns.
 */
@Mapper(componentModel = "spring")
public interface AdministratorUserMapper
        extends BaseMapper<AdministratorUserEntity, AdministratorUserDTO> {

}
