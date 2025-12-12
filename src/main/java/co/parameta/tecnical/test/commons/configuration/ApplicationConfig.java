package co.parameta.tecnical.test.commons.configuration;

import co.parameta.tecnical.test.commons.dto.AdministratorUserSecurityDTO;
import co.parameta.tecnical.test.commons.repository.AdministratorUserRepository;
import co.parameta.tecnical.test.commons.util.mapper.AdministratorUserMapper;
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

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AdministratorUserMapper administratorUserMapper;
    private final AdministratorUserRepository administratorUserRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> administratorUserRepository.findByEmail(username)
                .map(administratorUserMapper::toDto)
                .map(administratorUserDTO -> new AdministratorUserSecurityDTO(administratorUserDTO, List.of()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
