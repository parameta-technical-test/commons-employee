package co.parameta.technical.test.commons.util.constantes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class Constants {

    private Constants() {
    }

    public static final Map<Class<?>, Function<Object, ?>> CONVERTERS = new HashMap<>();
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

    public static final String NS = "http://parameta.co/technical/test/employee";


}
