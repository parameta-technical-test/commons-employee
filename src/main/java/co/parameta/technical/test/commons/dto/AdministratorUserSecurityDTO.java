package co.parameta.technical.test.commons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Security-specific DTO that adapts {@link AdministratorUserDTO}
 * to Spring Security's {@link UserDetails} contract.
 * <p>
 * This class is used by Spring Security during authentication
 * and authorization processes, providing user credentials,
 * authorities, and account status information.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdministratorUserSecurityDTO extends AdministratorUserDTO implements UserDetails {

    /**
     * User password required by Spring Security.
     * Internally mapped from {@code passwordEncoder}.
     */
    private String password;

    /**
     * Granted authorities assigned to the administrator user.
     */
    private Collection<? extends GrantedAuthority> authorities = List.of();

    /**
     * Creates a security user from a base administrator DTO.
     *
     * @param usuarioDTO base administrator user data
     * @param authorities granted security authorities
     */
    public AdministratorUserSecurityDTO(
            AdministratorUserDTO usuarioDTO,
            Collection<? extends GrantedAuthority> authorities
    ) {
        super(
                usuarioDTO.getCode(),
                usuarioDTO.getEmail(),
                usuarioDTO.getPasswordEncoder()
        );
        this.authorities = authorities;
    }

    /**
     * Returns the granted authorities for the authenticated user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the encoded password used for authentication.
     */
    @Override
    public String getPassword() {
        return super.getPasswordEncoder();
    }

    /**
     * Returns the username used for authentication.
     */
    @Override
    public String getUsername() {
        return super.getEmail();
    }

    /**
     * Indicates whether the user account has expired.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user account is locked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user credentials have expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user account is enabled.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
