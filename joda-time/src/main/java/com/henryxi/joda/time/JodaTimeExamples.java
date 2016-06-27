package com.henryxi.joda.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class JodaTimeExamples {
    public static void main(String[] args) {
        DateTime thisMonth1 = new DateTime().withDayOfMonth(1);
        DateTime thisMonth30 = new DateTime().withDayOfMonth(30);
        DateTime now = DateTime.now();
        System.out.println(now);
        //compare dates
        System.out.println(thisMonth1.isBefore(now));
        System.out.println(thisMonth30.isBefore(now));

    }
}
