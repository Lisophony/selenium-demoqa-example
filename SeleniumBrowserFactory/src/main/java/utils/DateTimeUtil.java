package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String getDate(final String format) {
        LogUtil.makeLog("Getting date with the passed format parameter");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date);
    }

    public static String getTime(final String format) {
        LogUtil.makeLog("Getting time with the passed format parameter");
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(time);
    }

    public static String getDateTime(final String dateFormat, final String timeFormat) {
        LogUtil.makeLog("Getting date and time with the passed format parameter");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat + " " + timeFormat);
        return formatter.format(dateTime);
    }

    public static String getYear() {
        LogUtil.makeLog("Getting current year");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return formatter.format(date);
    }

    public static String getMonth() {
        LogUtil.makeLog("Getting current month");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        return formatter.format(date);
    }

    public static String getDay() {
        LogUtil.makeLog("Getting current day");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return formatter.format(date);
    }

    public static String getNearestLeapYear() {
        LogUtil.makeLog("Getting nearest leap year");
        int currYear = Integer.parseInt(getYear());
        int currMonth = Integer.parseInt(getMonth());
        Integer leapYear = null;

        switch (currYear % 4) {
            case 0:
                leapYear = currYear;
                break;
            case 1:
                leapYear = currYear - 1;
                break;
            case 2:
                if (currMonth > 2) {
                    leapYear = currYear + 2;
                } else {
                    leapYear = currYear - 2;
                }
                break;
            case 3:
                leapYear = currYear + 1;
                break;
        }
        assert leapYear != null;
        return leapYear.toString();
    }

    public static boolean isBefore(final String year, final String month, final String day, final String format) {
        LogUtil.makeLog("Checking current date is before parameter date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate leapDate = LocalDate.parse(year + "/" + month + "/" + day, formatter);
        LocalDate currDate = LocalDate.now();
        return currDate.isBefore(leapDate);
    }
}
