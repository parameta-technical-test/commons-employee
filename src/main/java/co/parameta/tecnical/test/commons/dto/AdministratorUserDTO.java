package co.parameta.tecnical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorUserDTO {

    private String code;
    private String email;
    private String passwordEncoder;
}
