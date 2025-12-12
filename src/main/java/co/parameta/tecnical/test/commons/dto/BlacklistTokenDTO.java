package co.parameta.tecnical.test.commons.dto;

import co.parameta.tecnical.test.commons.entity.AdministratorUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistTokenDTO {

    private String token;
    private AdministratorUserDTO administratorUser;
    private Date dateCreate;
}
