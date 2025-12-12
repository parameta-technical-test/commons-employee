package co.parameta.tecnical.test.commons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdministratorUserSeguridadDTO extends AdministratorUserDTO implements UserDetails {

    private String password;

    private Collection<? extends GrantedAuthority> authorities = List.of();

    public AdministratorUserSeguridadDTO(AdministratorUserDTO usuarioDTO, Collection<? extends GrantedAuthority> authorities) {
        super(usuarioDTO.getCode(),
                usuarioDTO.getEmail(),
                usuarioDTO.getPasswordEncoder()
        );
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPasswordEncoder();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
