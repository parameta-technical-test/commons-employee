package co.parameta.tecnical.test.commons.util.constantes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Constants {

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

}
