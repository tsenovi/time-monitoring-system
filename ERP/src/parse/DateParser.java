package parse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private static final SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_FORMAT);

    private static boolean isCorrectInput(String data) {
        try {
            DateParser.sdfDate.parse(data);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectDate(String date) {
        return isCorrectInput(date);
    }

    public static Date parse(String date){
        Date dateOnly = null;
        try {
            dateOnly = sdfDate.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return dateOnly;
    }
}
