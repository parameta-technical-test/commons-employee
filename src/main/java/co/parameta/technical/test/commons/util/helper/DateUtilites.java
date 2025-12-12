package co.parameta.technical.test.commons.util.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtilites {

    public static Date sumarMesesAFecha(final Date date, final int meses) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, meses);
        return cal.getTime();
    }
    public static Date convertirStringToDate(String fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        Date date = null;

        try {
            date = formatter.parse(fecha);
        } catch (ParseException var4) {
            Logger.getLogger(DateUtilites.class.getName()).log(Level.INFO, "Error casting date");
        }

        return date;
    }

    public static int compararFechas(Date fechaDate1, Date fechaDate2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fechaDate1);
        c1.set(14, 0);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(fechaDate2);
        c2.set(14, 0);
        Date f1 = c1.getTime();
        Date f2 = c2.getTime();
        int resultado;
        if (f1.before(f2)) {
            resultado = -1;
        } else if (f2.before(f1)) {
            resultado = 1;
        } else {
            resultado = 0;
        }

        return resultado;
    }

    public static String formatDateToYMD(Date date) {
        if (date == null) return null;
        if (date.getTime() < 0) return "Invalid date";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

    public static String formatDateToDMY(Date date) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy", java.util.Locale.ROOT);
        sdf.setLenient(false);
        return sdf.format(date);
    }

}
