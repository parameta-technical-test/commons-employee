package co.parameta.tecnical.test.commons.util.mapper;

import co.parameta.tecnical.test.commons.dto.AdministratorUserDTO;
import co.parameta.tecnical.test.commons.entity.AdministratorUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministratorUserMapper {

    AdministratorUserDTO entityToDto(AdministratorUserEntity administratorUserEntity);

    AdministratorUserEntity dtoToEntity(AdministratorUserDTO administratorUserDTO);

}
