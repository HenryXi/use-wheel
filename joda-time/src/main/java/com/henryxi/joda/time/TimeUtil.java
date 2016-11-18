package com.henryxi.joda.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.concurrent.TimeUnit.*;

public class TimeUtil {
    private static String[] outputStr = new String[]{"year", "month", "week", "day", "hour", "minute"};
    private static long[] minisArray = new long[]{
            DAYS.toMillis(365),
            DAYS.toMillis(30),
            DAYS.toMillis(7),
            DAYS.toMillis(1),
            HOURS.toMillis(1),
            MINUTES.toMillis(1)
    };

    public static String getRelativeTime(final long date) {
        long duration = System.currentTimeMillis() - date;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minisArray.length - 1; i++) {
            long temp = duration / minisArray[i];
            if (temp > 0) {
                sb.append(temp)
                        .append(" ")
                        .append(outputStr[i])
                        .append(temp > 1 ? "s" : "")
                        .append(" ago");
                break;
            }
        }
        return sb.toString().isEmpty() ? "just now" : sb.toString();
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse("2013-11-18 12:43:20");
        long startTime = System.currentTimeMillis();
        System.out.println(getRelativeTime(start.getTime()));
        System.out.println("used: " + (System.currentTimeMillis() - startTime));
    }

}
