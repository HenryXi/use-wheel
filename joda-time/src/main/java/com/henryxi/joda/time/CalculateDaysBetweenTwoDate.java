package com.henryxi.joda.time;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateDaysBetweenTwoDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse("2016-09-01 15:20:20");
        Date end = simpleDateFormat.parse("2016-09-02 00:00:00");
        int minutes = Minutes.minutesBetween(new LocalDate(start), new LocalDate(end)).getMinutes();
        int days = Days.daysBetween(new LocalDate(start), new LocalDate(end)).getDays();
        for (int i = 0; i <= days; i++) {
            LocalDate d = new LocalDate(start).withFieldAdded(DurationFieldType.days(), i);
            System.out.println(d);
        }
    }
}
