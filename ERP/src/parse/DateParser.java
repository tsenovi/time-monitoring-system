package parse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_FORMAT);

    public static Date parse(String date) {
        Date dateOnly = null;
        try {
            dateOnly = sdfDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateOnly;
    }

    public static int parseWeekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static boolean isCorrectDate(String date) {
        return isCorrectInput(date);
    }

    private static boolean isCorrectInput(String data) {
        try {
            DateParser.sdfDate.parse(data);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
