package co.parameta.technical.test.commons.util.mapper;

import co.parameta.technical.test.commons.dto.AdministratorUserDTO;
import co.parameta.technical.test.commons.entity.AdministratorUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministratorUserMapper extends BaseMapper<AdministratorUserEntity, AdministratorUserDTO>{

}
