package helpFun;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class StringToDateParser {
    public static java.util.Date stringToDate(String str) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(str);
    }
}
