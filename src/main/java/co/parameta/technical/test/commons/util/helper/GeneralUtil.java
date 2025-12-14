package co.parameta.technical.test.commons.util.helper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static co.parameta.technical.test.commons.util.constantes.Constants.CONVERTERS;
import static co.parameta.technical.test.commons.util.constantes.Constants.DATE_PATTERNS;

public final class GeneralUtil {

    private GeneralUtil() {}


    static {
        CONVERTERS.put(Long.class,    GeneralUtil::toLong);
        CONVERTERS.put(Integer.class, GeneralUtil::toInteger);
        CONVERTERS.put(Double.class,  GeneralUtil::toDouble);
        CONVERTERS.put(Boolean.class, GeneralUtil::toBoolean);
        CONVERTERS.put(String.class,  v -> v == null ? null : v.toString());
        CONVERTERS.put(Date.class,    GeneralUtil::toDate);
        CONVERTERS.put(Instant.class,        GeneralUtil::toInstant);
    }

    private static Long toLong(Object v) {
        if (v == null) return null;
        if (v instanceof Number n) return n.longValue();
        if (v instanceof String s) {
            s = s.trim();
            if (s.isEmpty()) return null;
            try { return Long.parseLong(s); }
            catch (NumberFormatException ignored) {}
            try { return new BigDecimal(s).longValue(); }
            catch (NumberFormatException ignored) {}
        }
        if (v instanceof Date d) return d.getTime();
        return null;
    }

    private static Integer toInteger(Object v) {
        Long l = toLong(v);
        return (l == null) ? null : l.intValue();
    }

    private static Double toDouble(Object v) {
        if (v == null) return null;
        if (v instanceof Number n) return n.doubleValue();
        if (v instanceof String s) {
            s = s.trim();
            if (s.isEmpty()) return null;
            try { return Double.parseDouble(s); }
            catch (NumberFormatException ignored) {}
            try { return new BigDecimal(s).doubleValue(); }
            catch (NumberFormatException ignored) {}
        }
        if (v instanceof Date d) return (double) d.getTime();
        return null;
    }

    private static Boolean toBoolean(Object v) {
        if (v == null) return null;
        if (v instanceof Boolean b) return b;
        if (v instanceof Number n) return n.intValue() != 0;
        if (v instanceof String s) {
            String x = s.trim().toLowerCase(Locale.ROOT);
            return switch (x) {
                case "true","t","1","yes","y","si","sí" -> true;
                case "false","f","0","no","n"            -> false;
                default -> null;
            };
        }
        return null;
    }


    private static Date toDate(Object value) {
        if (value == null) return null;
        if (value instanceof Date d) return d;
        if (value instanceof Number n) return new Date(n.longValue());
        if (value instanceof String s) {
            String str = s.trim();
            if (str.isEmpty()) return null;
            if (str.matches("\\d{10,}")) {
                try { return new Date(Long.parseLong(str)); } catch (NumberFormatException ignored) {}
            }
            for (String p : DATE_PATTERNS) {
                try { return new SimpleDateFormat(p).parse(str); } catch (ParseException ignored) {}
            }
        }
        return null;
    }

    private static Instant toInstant(Object v) {
        if (v == null) return null;
        if (v instanceof Instant i) return i;
        if (v instanceof Date d) return d.toInstant();
        if (v instanceof Number n) return Instant.ofEpochMilli(n.longValue());
        if (v instanceof String s) {
            String str = s.trim();
            if (str.matches("\\d{10,}")) {
                try { return Instant.ofEpochMilli(Long.parseLong(str)); } catch (NumberFormatException ignored) {}
            }
            try { return Instant.parse(str); } catch (Exception ignored) {}
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T mapToValueObject(Object[] array, int index, Class<T> type, T defaultValue) {
        if (array == null || index < 0 || index >= array.length) {
            return defaultValue;
        }
        return mapToValueObject(array[index], type, defaultValue);
    }

    @SuppressWarnings("unchecked")
    public static <T> T mapToValueObject(Object value, Class<T> type, T defaultValue) {
        if (value == null || (value instanceof String s && s.trim().isEmpty())) {
            return defaultValue;
        }
        Function<Object, ?> converter = CONVERTERS.get(type);
        if (converter != null) {
            try {
                Object converted = converter.apply(value);
                return (converted != null) ? (T) converted : defaultValue;
            } catch (Exception ex) {
                return defaultValue;
            }
        }
        try {
            return type.cast(value);
        } catch (ClassCastException ex) {
            return defaultValue;
        }
    }

    public static <T> T get(Supplier<T> supplier, T defaultValue) {
        try {
            T value = supplier.get();
            return value != null ? value : defaultValue;
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    public static Map<String, Integer> diff(
            Date startDate,
            Date endDate
    ) {

        Map<String, Integer> result = new HashMap<>();
        result.put("years", 0);
        result.put("months", 0);
        result.put("days", 0);

        if (startDate == null || endDate == null) return result;

        ZoneId zone = ZoneId.of("America/Bogota");

        LocalDate start = startDate.toInstant().atZone(zone).toLocalDate();
        LocalDate end = endDate.toInstant().atZone(zone).toLocalDate();

        if (end.isBefore(start)) {
            LocalDate tmp = start;
            start = end;
            end = tmp;
        }

        int years = (int) ChronoUnit.YEARS.between(start, end);

        int months = years * 12;

        LocalDate anniversary = start.plusYears(years);
        int days = (int) ChronoUnit.DAYS.between(start, anniversary);

        result.put("years", years);
        result.put("months", months);
        result.put("days", days);

        return result;
    }



}
