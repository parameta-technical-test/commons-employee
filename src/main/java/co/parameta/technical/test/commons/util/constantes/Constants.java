package co.parameta.technical.test.commons.util.constantes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Centralized constants used across the commons module.
 * <p>
 * This class defines shared values related to data conversion,
 * date parsing, and SOAP namespace configuration.
 */
public final class Constants {

    /**
     * Private constructor to prevent instantiation.
     */
    private Constants() {
    }

    /**
     * Map of type converters used to dynamically transform
     * objects between different target types.
     * <p>
     * The key represents the target class, while the value
     * defines the conversion logic.
     */
    public static final Map<Class<?>, Function<Object, ?>> CONVERTERS = new HashMap<>();

    /**
     * Supported date patterns used for parsing string-based
     * date values coming from external systems or user input.
     * <p>
     * Patterns include common ISO formats and regional formats.
     */
    public static final List<String> DATE_PATTERNS = Arrays.asList(
            "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy-MM-dd HH:mm:ss.S",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd",
            "dd/MM/yyyy",
            "dd-MM-yyyy",
            "yyyyMMddHHmmss",
            "yyyyMMdd"
    );

    /**
     * XML namespace used for SOAP requests and responses
     * related to employee services.
     */
    public static final String NS = "http://parameta.co/technical/test/employee";

}
