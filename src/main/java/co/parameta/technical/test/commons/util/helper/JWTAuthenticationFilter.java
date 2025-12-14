package co.parameta.technical.test.commons.util.helper;

import co.parameta.technical.test.commons.repository.BlacklistTokenRepository;
import co.parameta.technical.test.commons.service.IJwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * JWT authentication filter responsible for validating incoming requests
 * using Bearer tokens.
 * <p>
 * This filter:
 * <ul>
 *   <li>Extracts JWT tokens from the {@code Authorization} header</li>
 *   <li>Validates token signature and expiration</li>
 *   <li>Checks token revocation against the blacklist</li>
 *   <li>Populates the Spring Security context if authentication is valid</li>
 * </ul>
 * <p>
 * It runs once per request and integrates seamlessly with Spring Security.
 */
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    /**
     * Utility used to match request paths against excluded URL patterns.
     */
    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    /**
     * Service used for JWT parsing, validation, and claim extraction.
     */
    private final IJwtService jwtService;

    /**
     * Loads user details based on the username extracted from the token.
     */
    private final UserDetailsService userDetailsService;

    /**
     * Repository used to validate whether a token has been revoked.
     */
    private final BlacklistTokenRepository blacklistTokenRepository;



    /**
     * Performs JWT authentication for incoming requests.
     * <p>
     * If a valid Bearer token is found:
     * <ul>
     *   <li>The user is authenticated</li>
     *   <li>The security context is populated</li>
     * </ul>
     * Otherwise, the request proceeds without authentication.
     *
     * @param request incoming HTTP request
     * @param response HTTP response
     * @param filterChain filter chain
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtService.getUsernameFromToken(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(token, userDetails)
                    && !blacklistTokenRepository.existsByToken(token)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Extracts the JWT token from the {@code Authorization} header.
     *
     * @param request HTTP request
     * @return raw JWT token or {@code null} if not present
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

}
