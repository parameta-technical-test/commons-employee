package co.parameta.technical.test.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Generic response wrapper used across REST and SOAP integrations.
 * <p>
 * Provides a standardized structure to return status codes,
 * response messages, and optional payload data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGeneralDTO implements Serializable {

    /**
     * HTTP-like status code representing the result of the operation.
     */
    private Integer status;

    /**
     * Payload returned by the service.
     * <p>
     * Can contain any type of response data or be {@code null}.
     */
    private Object data;

    /**
     * Descriptive message associated with the response.
     */
    private String message;

}
