package co.parameta.technical.test.commons.util.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom {@link AccessDeniedHandler} implementation used to handle
 * authorization errors when an authenticated user does not have
 * sufficient permissions to access a resource.
 * <p>
 * This handler returns a standardized JSON response with
 * HTTP 403 (Forbidden) status.
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * JSON mapper used to serialize error responses.
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Handles access denied exceptions triggered by Spring Security.
     * <p>
     * Builds a structured JSON response containing:
     * <ul>
     *   <li>Timestamp</li>
     *   <li>HTTP status</li>
     *   <li>Error description</li>
     *   <li>Exception message</li>
     *   <li>Requested path</li>
     * </ul>
     *
     * @param request HTTP request that caused the access denial
     * @param response HTTP response to be sent to the client
     * @param accessDeniedException exception raised by Spring Security
     * @throws IOException if the response cannot be written
     * @throws ServletException if a servlet-related error occurs
     */
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpServletResponse.SC_FORBIDDEN);
        body.put("error", "Forbidden");
        body.put("message", accessDeniedException.getMessage());
        body.put("path", request.getRequestURI());

        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
