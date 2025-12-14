package co.parameta.technical.test.commons.configuration;

import co.parameta.technical.test.commons.dto.AdministratorUserSecurityDTO;
import co.parameta.technical.test.commons.repository.AdministratorUserRepository;
import co.parameta.technical.test.commons.util.mapper.AdministratorUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Spring Security core configuration.
 * <p>
 * This class defines the main security-related beans used by the application,
 * including authentication management, password encoding, and user detail resolution.
 * It integrates Spring Security with the application's administrator user model.
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AdministratorUserMapper administratorUserMapper;
    private final AdministratorUserRepository administratorUserRepository;

    /**
     * Provides the {@link AuthenticationManager} used to authenticate user credentials.
     *
     * @param config Spring authentication configuration
     * @return configured {@link AuthenticationManager}
     * @throws Exception if the manager cannot be created
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Configures the {@link AuthenticationProvider} responsible for user authentication.
     * <p>
     * Uses a {@link DaoAuthenticationProvider} backed by a custom {@link UserDetailsService}
     * and a BCrypt password encoder.
     *
     * @return configured {@link AuthenticationProvider}
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Defines the password encoder used to hash and verify user passwords.
     *
     * @return {@link BCryptPasswordEncoder} instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Provides the {@link UserDetailsService} implementation used by Spring Security.
     * <p>
     * Loads administrator users by email and maps them to
     * {@link AdministratorUserSecurityDTO} instances.
     *
     * @return configured {@link UserDetailsService}
     * @throws UsernameNotFoundException if the user does not exist
     */
    @Bean
    public UserDetailsService userDetailService() {
        return username -> administratorUserRepository.findByEmail(username)
                .map(administratorUserMapper::toDto)
                .map(dto -> new AdministratorUserSecurityDTO(dto, List.of()))
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found: " + username)
                );
    }

}
