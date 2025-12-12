package co.parameta.tecnical.test.commons.util.exception;


public class MensajePersonalizadoException extends RuntimeException {

    public MensajePersonalizadoException(String message) {
        super(message);
    }

    public MensajePersonalizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
