package co.parameta.technical.test.commons.util.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom {@link AuthenticationEntryPoint} implementation used to handle
 * authentication errors when a request is made without valid credentials.
 * <p>
 * This entry point is triggered when an unauthenticated user attempts
 * to access a protected resource and returns a standardized JSON
 * response with HTTP 401 (Unauthorized).
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * JSON mapper used to serialize authentication error responses.
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Handles authentication exceptions raised by Spring Security.
     * <p>
     * Builds a structured JSON response containing:
     * <ul>
     *   <li>Timestamp</li>
     *   <li>HTTP status</li>
     *   <li>Error type</li>
     *   <li>Authentication error message</li>
     *   <li>Requested path</li>
     * </ul>
     *
     * @param request HTTP request that triggered the authentication failure
     * @param response HTTP response to be sent to the client
     * @param authException authentication exception raised by Spring Security
     * @throws IOException if the response cannot be written
     * @throws ServletException if a servlet-related error occurs
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getRequestURI());

        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
