package utils;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate stringToLocalDate(String value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(value, formatter);
    }

    public static Date localDatetoDate(LocalDate localDate) {
        return Date.valueOf(localDate);
    }

    public static Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime){
        return Timestamp.valueOf(localDateTime);
    }
}
