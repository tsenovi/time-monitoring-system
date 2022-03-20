package parse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TIME_FORMAT = "HH:mm";

    private static final SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_FORMAT);
    private static final SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_FORMAT);

    private static boolean isCorrectInput(String data, SimpleDateFormat format) {
        try {
            format.parse(data);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectDate(String date) {
        return isCorrectInput(date, sdfDate);
    }

    public static boolean isCorrectTime(String time) {
        return isCorrectInput(time, sdfTime);
    }


    public static Date parse(String date, String time) {
        Date dateOnly = null;
        Date timeOnly = null;
        try {
            dateOnly = sdfDate.parse(date);
            timeOnly = sdfTime.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert dateOnly != null;
        Date dateTime = new Date(dateOnly.getTime());
        if(timeOnly != null) {
            dateTime.setHours(timeOnly.getHours());
            dateTime.setMinutes(timeOnly.getMinutes());
        }
        return dateTime;
    }

    public static Date parse(String time) {
        Date timeOnly = null;
        try {
            timeOnly = sdfTime.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timeOnly;
    }
}
