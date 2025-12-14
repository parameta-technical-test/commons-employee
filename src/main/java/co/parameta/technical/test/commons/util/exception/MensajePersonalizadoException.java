package co.parameta.technical.test.commons.util.exception;

/**
 * Custom runtime exception used to represent business or domain-specific errors.
 * <p>
 * This exception allows the application to throw meaningful messages that can be
 * safely propagated to the REST layer and handled by the global exception handler.
 */
public class MensajePersonalizadoException extends RuntimeException {

    /**
     * Creates a new custom exception with a descriptive message.
     *
     * @param message error description
     */
    public MensajePersonalizadoException(String message) {
        super(message);
    }

    /**
     * Creates a new custom exception with a message and a root cause.
     *
     * @param message error description
     * @param cause original exception
     */
    public MensajePersonalizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
