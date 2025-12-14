package co.parameta.technical.test.commons.util.enums;

/**
 * Enumeration that represents the validation status of a JWT token.
 * <p>
 * This enum is used to clearly indicate the result of token verification
 * during authentication and authorization processes.
 */
public enum TokenStatusEnum {

    /**
     * The token is valid, correctly signed, not expired,
     * and not present in the blacklist.
     */
    VALID,

    /**
     * The token has expired based on its expiration claim.
     */
    EXPIRED,

    /**
     * The token is invalid due to format issues, signature errors,
     * blacklist revocation, or general validation failure.
     */
    INVALID
}
