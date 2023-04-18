package com.namrata2.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class TimeValidatorAndConverter {

    public static String convert12HrTo24HrFormat(final String s) throws ParseException {
        final String s1 = addTrailingZeros(s.trim());
//        final String result =
//                LocalTime.parse(s1,
//                                DateTimeFormatter.ofPattern(
//                                        "hh:mma",
//                                        Locale.US
//                                )
//                        )
//                        .format(DateTimeFormatter.ofPattern("HH:mm"));
//        return result;


        int hour = Integer.parseInt(s1.substring(0, 2));
        String timeOfDay = s1.substring(5, 7);

        if(timeOfDay.equalsIgnoreCase("AM"))
        {
            if(hour == 12)
                hour = 0;
        }
        else if(timeOfDay.equalsIgnoreCase("PM"))
        {
            if(hour != 12)
                hour += 12;
        }

        return String.format("%02d%s", hour, s1.substring(3, 5));
    }

    private static String addTrailingZeros(String s) {
        String s1 = StringUtils.leftPad(s.trim(), 7, "0");
        return s1;


    }

    public static boolean is12HrFormat(final String s) {
        String[] s1 = s.split(":");
        var isPMAMSuffix = s.endsWith("am") || s.endsWith("pm") || s.endsWith("AM") || s.endsWith("PM");
        if (s1.length != 0 && isPMAMSuffix && Integer.parseInt(s1[0]) <= 12) {
            return true;
        }
        return false;

    }

    public static boolean checkIf12HrFormat(final String time) {
        String regexPattern
                = "(1[012]|[1-9]):"
                + "[0-5][0-9](\\s)"
                + "?(?i)(am|pm)";

        final Pattern compiledPattern
                = Pattern.compile(regexPattern);

        if (time == null) {
            return false;
        }

        final Matcher m = compiledPattern.matcher(time);

        return m.matches();
    }


    public static boolean checkIf24HrFormat(final String time) {

        final String regex = "([01]?[0-9]|2[0-3])[0-5][0-9]";

        final Pattern p = Pattern.compile(regex);

        if (time == null) {
            return false;
        }

        final Matcher m = p.matcher(time);

        return m.matches();

    }


}
