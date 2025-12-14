package co.parameta.technical.test.commons.util.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for REST controllers.
 * <p>
 * This class centralizes the handling of application and security exceptions,
 * ensuring consistent JSON error responses across the API.
 * <p>
 * It covers:
 * <ul>
 *   <li>Authentication errors</li>
 *   <li>Custom business exceptions</li>
 *   <li>Missing endpoints or resources</li>
 *   <li>Unexpected system errors</li>
 * </ul>
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * Handles requests to non-existent static resources.
     *
     * @param ex exception thrown when a resource is not found
     * @return HTTP 404 response without body
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Void> handleNoResource(NoResourceFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    /**
     * Handles custom business exceptions defined by the application.
     * <p>
     * Returns a standardized JSON response with HTTP 500 status.
     *
     * @param ex custom exception instance
     * @param request current web request
     * @return error response with detailed message
     */
    @ExceptionHandler(MensajePersonalizadoException.class)
    public ResponseEntity<Object> excepcionPersonalizada(
            MensajePersonalizadoException ex,
            WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false));

        log.error("There was an error on the server: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles authentication-related exceptions.
     * <p>
     * Typically triggered when credentials are invalid or missing.
     *
     * @param ex authentication exception
     * @param request current web request
     * @return HTTP 401 response with generic authentication message
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthExceptions(
            AuthenticationException ex,
            WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Unauthorized");
        body.put("message", "Incorrect username or password");
        body.put("path", request.getDescription(false));

        log.error("Authentication error: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Handles requests made to non-existing endpoints.
     *
     * @param ex exception thrown when no handler is found
     * @param request current web request
     * @return HTTP 404 response with error details
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNotFound(
            NoHandlerFoundException ex,
            WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", "The requested endpoint does not exist.");
        body.put("path", request.getDescription(false));

        log.error("Endpoint not found: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles all unhandled exceptions as a fallback mechanism.
     *
     * @param ex unexpected exception
     * @param request current web request
     * @return HTTP 500 response with generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(
            Exception ex,
            WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message",
                "We apologize, an internal error has occurred. Please try again later.");
        body.put("path", request.getDescription(false));

        log.error("Unhandled server error: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
